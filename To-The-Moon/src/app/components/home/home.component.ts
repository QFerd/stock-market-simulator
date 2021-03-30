import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { stock } from 'src/app/models/stock.model';
import { STOCKS } from 'src/app/PotentialStocks';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  stocks: stock[] = [

    { name: "AMC" },
    { name: "GME" }
  
  ];
  constructor(public appComponent:AppComponent) {
    
   }

  ngOnInit(): void {
    console.log(this.stocks[0]['name'])
  }
  stocksInputted:string[]=[];
  createPortoflio():void {
    for(let i =1;i<=6;i++){
      var doc =document.getElementById(`stock${i}`) as HTMLInputElement;
      if(!this.stocksInputted.find(e=>e ==doc.value))
        this.stocksInputted.push(doc.value);
    }
    console.log(this.stocksInputted);
    
  }

  getPortoflio():void {
    
  }
}
