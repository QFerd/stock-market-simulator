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
  timerId:any = setInterval(()=>{},5000);
  constructor(public appComponent: AppComponent, public userService: UserServiceService, private chartService: ChartService, private gameService:GameService) {
    if (this.appComponent.user.portfolio)
       this.timerId = setInterval(()=>{
         this.updateGame();
        },5000);
    // window.onload= this.populateTable;
   }
   
  userToDisplay:User = this.appComponent.user;
  ngOnInit(): void {
    
    console.log(this.stocks[0]['stockSymbol'])
    this.chartService.getData().subscribe(data => {
      this.recievedData = data;
      console.log(data)
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
    console.log("updating game");
    // this.populateTable();
    if(this.gameService.getGamePhase(this.appComponent.user))
  }


  public recievedData: any;

  public date: String = "2021-01";

  public dataArray: any = [];

  public populateTable() {
    this.barChartData=[]
    console.log("doing it");
    var date = this.date;
    var APIDataArr = []
    console.log(this.recievedData["Time Series (Daily)"][`${date}-05`]["4. close"]);
    APIDataArr.push(parseInt(this.recievedData["Time Series (Daily)"][`${date}-05`]["4. close"]))
    APIDataArr.push(parseInt(this.recievedData["Time Series (Daily)"][`${date}-06`]["4. close"]))
    APIDataArr.push(parseInt(this.recievedData["Time Series (Daily)"][`${date}-07`]["4. close"]))
    APIDataArr.push(parseInt(this.recievedData["Time Series (Daily)"][`${date}-08`]["4. close"]))
    APIDataArr.push(parseInt(this.recievedData["Time Series (Daily)"][`${date}-11`]["4. close"]))
    APIDataArr.push(parseInt(this.recievedData["Time Series (Daily)"][`${date}-12`]["4. close"]))
    APIDataArr.push(parseInt(this.recievedData["Time Series (Daily)"][`${date}-13`]["4. close"]))
    console.log(APIDataArr)
    //this.dataArray = APIDataArr
    this.barChartData.push({ data: APIDataArr, label: 'Inputted Data', fill: false, backgroundColor:'red',borderColor:'blue'});
    
    this.barChartLabels = ["testing", '2007', '2008', '2009', '2010', '2011', '2012']
  }

  //For chart:

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true,
    elements: {
      line: {
        tension: 0
      }
    }
  };
  public barChartLabels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType: ChartType = 'line';
  public barChartLegend = true;
  public barChartData: any = [
    { data: this.dataArray, label: 'Series A', fill: false },
    { data: [130, 120, 130, 120, 130, 120, 130], label: 'Series B' },
    { data: [120, 125, 122, 130, 128, 127, 120], label: 'Series C' }
  ];

}
