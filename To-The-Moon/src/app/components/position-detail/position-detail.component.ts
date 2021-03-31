
import { Component, OnInit, Input } from '@angular/core';
import { Position } from '../../models/position.model';

import { StockService } from 'src/app/services/stock.service';
import { HomeComponent } from '../home/home.component';
import { ChartType } from 'chart.js';
import { ChartService } from 'src/app/services/chart.service';
import { GameService } from 'src/app/services/game.service';
import { AppComponent } from 'src/app/app.component';


@Component({
  selector: 'app-position-detail',
  templateUrl: './position-detail.component.html',
  styleUrls: ['./position-detail.component.css']
})
export class PositionDetailComponent implements OnInit {
  @Input() position: Position|undefined;

  constructor(public stockService:StockService, public homeComponent:HomeComponent,public chartService:ChartService,public gameService:GameService, public appComponent:AppComponent) {
    this.position = {positionId:0,quantity:0,stockSymbol:''};
    this.updateGame(true);
    console.log("hello")
   }
   recievedData:any
  timerId: any = setInterval(() => { this.updateGame(false)}, 3000);
  ngOnInit() {
    
    if(this.position!=undefined)
      console.log(this.stockService.getStockBySymbol(this.position.stockSymbol,"2020-10-05"))
      if(this.position)
      {

      }
    
  }

  updateGame(doIt: boolean) {
    console.log("checking game");
    // this.populateTable();
    this.gameService.getGamePhase(this.appComponent.user).subscribe(game => {
      if (this.appComponent.user.game?.phase != game.phase || doIt) {
        console.log("updating");
        this.appComponent.user.game = game;
        this.barChartData = [];
        this.barChartLabels = []

        if (this.position)
          this.chartService.getData(this.position.stockSymbol).subscribe(data => {
            this.recievedData = data;
            console.log(data)
            this.populateTable(data);



          })
      }
    })
  }

  public barChartOptions = {
    title: {
      display: true,
      text: 'Total Balance',
      fontSize: 30
    },

    scaleShowVerticalLines: false,
    responsive: true,
    elements: {
      line: {
        tension: 0
      }
    }
  };
  public title: string = 'balance'
  public barChartLabels = [''];
  public barChartType: ChartType = 'line';
  public barChartLegend = true;
  public barChartData: any = [
  ];


  public populateTable(recievedData: any): number {
    var topKey = "Monthly Time Series"
    var getClose = "4. close";
    var info = recievedData[topKey];
    console.log(info)
    Object.keys(recievedData).map(k => recievedData[k])
    var container = Object.keys(info);
    console.log(container)

    var indexOfStartDateInInfo = container.findIndex(k => k.includes(`${this.homeComponent.startYear}-0${this.homeComponent.startMonth}`))
    console.log(container[indexOfStartDateInInfo]);
    var APIDataArr = []

    var startDateInInfo = container[indexOfStartDateInInfo];
    this.barChartLabels.push(startDateInInfo)
    console.log(info[startDateInInfo][getClose])
    APIDataArr.push(Number.parseFloat(recievedData[topKey][startDateInInfo][getClose]))
    for (let i = 0; i < this.homeComponent.phase; i++) {
      var laterDateInInfo = container[indexOfStartDateInInfo + i];
      this.barChartLabels.push(laterDateInInfo)
      console.log(laterDateInInfo)
      console.log(info[laterDateInInfo][getClose])
      APIDataArr.push(Number.parseFloat(info[laterDateInInfo][getClose]))
    }

    this.barChartData.push({ data: APIDataArr, label: 'Inputted Data', fill: false, backgroundColor: 'red', borderColor: 'blue' });

    console.log(APIDataArr[APIDataArr.length - 1]);
    return APIDataArr[APIDataArr.length - 1] - APIDataArr[APIDataArr.length - 2];
  }

}