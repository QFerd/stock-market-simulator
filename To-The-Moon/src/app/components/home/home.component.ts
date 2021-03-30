import { Position } from 'src/app/models/position.model';
import { convertUpdateArguments } from '@angular/compiler/src/compiler_util/expression_converter';
import { Component, OnInit } from '@angular/core';
import { TimeInterval } from 'rxjs';
import { AppComponent } from 'src/app/app.component';
import { Portfolio } from 'src/app/models/portfolio.model';
import { stock } from 'src/app/models/stock.model';
import { STOCKS } from 'src/app/PotentialStocks';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  stocks: stock[] = [

    { stockSymbol: "AMC" },
    { stockSymbol: "GME" }
  
  ];
  timerId:any = setInterval(()=>{},5000);
  constructor(public appComponent:AppComponent) {
    if (this.appComponent.user.portfolio)
       this.timerId = setInterval(()=>{
         this.updateGame();
        },5000);
   }
   

  ngOnInit(): void {
    console.log(this.stocks[0]['stockSymbol'])
  }
  stocksInputted:Position[]=[];
  newPortfolio:Portfolio = {cash_value:10000,portfolio_id:0,positions:[],stock_value:0,total_value:10000};
  createPortoflio():void {
    for(let i =1;i<=6;i++){
      var doc =document.getElementById(`stock${i}`) as HTMLInputElement;
      if (!this.stocksInputted.find(e => e.stockSymbol== doc.value )&&doc.value!="Select Stock")
        this.stocksInputted.push({stockSymbol:doc.value,portfolio_id_fk:0,portfolio_portfolio_id:0,position_id:0,quantity:0});
    }
    console.log(this.stocksInputted);
    if(this.stocksInputted.length>0)
      // this.newPortfolio.positions.push(this.stocksInputted);
    this.appComponent.user.portfolio
  }

  getPortoflio():void {
    
  }

  updateGame(){
    
  }
}
