import { Position } from '../../models/position.model';
import { PositionService } from './../../services/position.service';
import { Component, OnInit } from '@angular/core';
import { POSITIONS } from '../../mock-positions'
import { AppComponent } from 'src/app/app.component';
import { StockService } from 'src/app/services/stock.service';
import { templateJitUrl } from '@angular/compiler';
import { HomeComponent } from '../home/home.component';
import { ChartService } from 'src/app/services/chart.service';


@Component({
  selector: 'app-positions',
  templateUrl: './positions.component.html',
  styleUrls: ['./positions.component.css']
})
export class PositionsComponent implements OnInit {

  selectedPosition?: Position;

  lastMonthGainLoss:Map<string,number> = new Map<string,number>();

  positions: Position[] = [];
  public tempHolder:any;
  constructor(private stockService:StockService,private positionService: PositionService, private appComponent:AppComponent,public homeComponent:HomeComponent, public chartService:ChartService) { }
  timeVar = setTimeout(()=>this.ngOnInit(),200);
  ngOnInit(): void {

    this.getPositions();
    for(let position in this.positions){
      console.log(this.positions[position])
      document.getElementById(`buy${ this.positions[position] }`)
    }
  }

  onSelect(position: Position): void {
    this.selectedPosition = position;
  }
  data:Object={};
  testing(){
    
    console.log(this.stockService.getStockBySymbol('AMC','2020-03-15').subscribe(inputted=>this.tempHolder=inputted));
    console.log(this.tempHolder)
    console.log(this.tempHolder['Meta Data']);
    console.log(this.tempHolder['Meta Data']['2. Symbol']);
  }
  
  getPositions(): void {
    if(this.appComponent.user.portfolio)
    if (this.appComponent.user.portfolio.positionList){
      this.positions=this.appComponent.user.portfolio.positionList;
      this.appComponent.user.portfolio.positionList.forEach(p =>{
        this.chartService.getData(p.stockSymbol).subscribe(data =>{

        })
      })
    }
   
  }


  buy(){

  }

  sell(){

  }
}
