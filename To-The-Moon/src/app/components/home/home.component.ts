import { Position } from 'src/app/models/position.model';
import { convertUpdateArguments } from '@angular/compiler/src/compiler_util/expression_converter';
import { Component, OnInit } from '@angular/core';
import { TimeInterval } from 'rxjs';
import { AppComponent } from 'src/app/app.component';
import { Portfolio } from 'src/app/models/portfolio.model';
import { stock } from 'src/app/models/stock.model';
import { UserServiceService } from 'src/app/services/user-service.service';
import { User } from 'src/app/models/user.model';
import { ChartType } from 'chart.js';
import { ChartService } from 'src/app/services/chart.service';
import { GameService } from 'src/app/services/game.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public cashRemaining:number = 0;
  public stockValue: number = 0;
  public totalValue: number = 0;

  public startYear:number=0;
  public startMonth:number=0;
  public startDay: number=0;

  public phase:number=0;


  stocks: stock[] = [
    { stockSymbol: "AMC" },
    { stockSymbol: "GME" },
    {stockSymbol:"IBM"},
    {stockSymbol:"BB"},
    {stockSymbol:"PSX"},
    {stockSymbol:"ENB"},
    {stockSymbol:"COP"},
    {stockSymbol:"TX"},
    {stockSymbol:"CMC"}
  ];
  timerId:any = setInterval(()=>{},3000);
  constructor(public appComponent: AppComponent, public userService: UserServiceService, private chartService: ChartService, private gameService:GameService) {

    if (this.appComponent.user.portfolio)
    { 
      this.cashRemaining= this.appComponent.user.portfolio.cashValue;
      this.stockValue = this.appComponent.user.portfolio.stockValue;
      this.totalValue = this.appComponent.user.portfolio.totalValue;
       this.timerId = setInterval(()=>{
         this.updateGame();
        },3000);
    // window.onload= this.populateTable;
      }
   }
   
  userToDisplay:User = this.appComponent.user;
  ngOnInit(): void {
    
    if(this.appComponent.user.game){
      var startDateString = this.appComponent.user.game.startDate
      var startDateArray = startDateString.split('-');
      this.startYear=parseInt(startDateArray[0]);
      this.startMonth=parseInt(startDateArray[1]);
      this.startDay = parseInt(startDateArray[2]);
      this.phase= this.appComponent.user.game.phase
      console.log("we are on phase " + this.phase)
      console.log(startDateArray);
      console.log("Start Year ="+ this.startYear);
      console.log("Start Month =" + this.startMonth);
      console.log("Start Day =" + this.startDay);
    }
    this.chartService.getData('IBM').subscribe(data => {
      this.recievedData = data;
      console.log(data)
      this.barChartData = [];
      this.barChartLabels = []
      this.populateTable(data);
    })
  }


  


  stocksInputted:Position[]=[];
  newPortfolio:Portfolio = {cashValue:10000,portfolioId:0,positionList:[],stockValue:0,totalValue:10000};
  createPortoflio():void {
    for(let i =1;i<=6;i++){
      var doc =document.getElementById(`stock${i}`) as HTMLInputElement;
      if (!this.stocksInputted.find(e => e.stockSymbol== doc.value )&&doc.value!="Select Stock")
        this.stocksInputted.push({stockSymbol:doc.value,positionId:0,quantity:0});
    }
    console.log(this.stocksInputted);
    if(this.stocksInputted.length>0){
       this.newPortfolio.positionList=this.stocksInputted;
       console.log(this.newPortfolio);
       this.appComponent.user.portfolio=this.newPortfolio;
       console.log(this.appComponent.user.portfolio);
       localStorage.setItem("user",JSON.stringify(this.appComponent.user));
       this.userService.setUser(this.appComponent.user).subscribe(data=>
        console.log(data));
        this.userService.login(this.appComponent.user.username,"");
    }
    console.log(this.appComponent.user);
  }

  getPortoflio():void {
    
  }

  updateGame(){
    console.log("checking game");
    // this.populateTable();
    this.gameService.getGamePhase(this.appComponent.user).subscribe(game=>
      {
        if(this.appComponent.user.game?.phase!=game.phase){
          console.log("updating");
          this.appComponent.user.game=game;
          var stockBalance = this.getBalances();
          this.phase = game.phase
          this.barChartData = [];
          this.barChartLabels = []
          console.log(this.populateTable(this.recievedData));
        }
      })
  }
  getBalances():number {
    

    return 0;
  }


  public recievedData: any;

  public date: String = "2021-01";

  public dataArray: any = [];

  public populateTable(recievedData:any):number {
    var topKey = "Monthly Time Series"
    var getClose = "4. close";
    var info = recievedData[topKey];
    console.log(info)
    Object.keys(recievedData).map(k => this.recievedData[k] )
    var container = Object.keys(info);
    console.log(container)
    if(this.startMonth<=9)
      var indexOfStartDateInInfo= container.findIndex(k=>k.includes(`${this.startYear}-0${this.startMonth}`))
    else 
      var indexOfStartDateInInfo = container.findIndex(k => k.includes(`${this.startYear}-${this.startMonth}`))
    console.log(container[indexOfStartDateInInfo]);
    var APIDataArr = []

    var startDateInInfo = container[indexOfStartDateInInfo];
    this.barChartLabels.push(startDateInInfo)
    console.log(info[startDateInInfo][getClose])
    APIDataArr.push(Number.parseFloat(recievedData[topKey][startDateInInfo][getClose]))
    for(let i =0; i<this.phase;i++){
      var laterDateInInfo = container[indexOfStartDateInInfo+i];
      this.barChartLabels.push(laterDateInInfo)
      console.log(laterDateInInfo)
      console.log(info[laterDateInInfo][getClose])
      APIDataArr.push(Number.parseFloat(info[laterDateInInfo][getClose]))
    }
    
    this.barChartData.push({ data: APIDataArr, label: 'Inputted Data', fill: false, backgroundColor:'red',borderColor:'blue'});
    
    console.log(APIDataArr[APIDataArr.length - 1]);
    return APIDataArr[APIDataArr.length-1]-APIDataArr[APIDataArr.length-2];
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
  public title:string = 'balance'
  public barChartLabels = [''];
  public barChartType: ChartType = 'line';
  public barChartLegend = true;
  public barChartData: any = [
  ];

}
