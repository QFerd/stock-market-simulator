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

  createPortoflio():void {

  }

  getPortoflio():void {
    
  }
}
