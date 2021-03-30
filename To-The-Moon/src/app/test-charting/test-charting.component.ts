import { Component, OnInit } from '@angular/core';
import { ChartType } from 'angular-google-charts';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-test-charting',
  templateUrl: './test-charting.component.html',
  styleUrls: ['./test-charting.component.css']
})
export class TestChartingComponent implements OnInit {

  constructor(public stockServer:StockService) { 
    this.dataTable=[['',0]];
  }
  public tempHolder: any;
  public dataTable: [[string,number]];
  ngOnInit(): void {
    console.log(this.stockServer.getStockBySymbol('AMC', '2020-03-15').subscribe(inputted =>{ 
      this.tempHolder = inputted;
      console.log(this.tempHolder);
      this.tempHolder = this.tempHolder['Monthly Time Series'];
      console.log(this.tempHolder);
      var keys = Object.keys(this.tempHolder);
      console.log(keys)
      var valuesOfFirstKey = this.tempHolder[keys[0]];
      var values = valuesOfFirstKey['4. close']
      console.log(values);
      var keyValue = {}
    }));
  }
  title = 'Browser market shares at a specific website, 2014';
  type:ChartType = ChartType.LineChart;

  doTheData(){
  }

  data = [
    ['Firefox', 45.0],
    ['IE', 26.8],
    ['Chrome', 12.8],
    ['Safari', 8.5],
    ['Opera', 6.2],
    ['Others', 0.7]
  ];
  columnNames = 
  ["Month", "Tokyo", "New York", "Berlin", "Paris"];
  options = {
    hAxis: {
      title: 'Month'
    },
    vAxis: {
      title: 'Temperature'
    },
  };
  width = 550;
  height = 400;
}
