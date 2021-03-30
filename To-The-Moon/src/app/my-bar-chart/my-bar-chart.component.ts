import { Component, OnInit } from '@angular/core';
import * as Chart from 'chart.js';
import { ChartType } from 'chart.js';
import { Observable } from 'rxjs';
import { ChartService } from '../services/chart.service';

@Component({
  selector: 'app-my-bar-chart',
  templateUrl: './my-bar-chart.component.html',
  styleUrls: ['./my-bar-chart.component.css']
})


export class MyBarChartComponent implements OnInit {

  constructor(private chartService: ChartService) { }

  public recievedData: any;

  public date: String = "2021-01";

  public dataArray: any = [];

  public populateTable() {
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
    this.dataArray = APIDataArr
      this.barChartData = [
        {data: this.dataArray, label: 'Inputted Data',fill:false},
        {data: [130, 120, 130, 120, 130, 120, 130], label: 'AMC'},
        {data: [120, 125, 122, 130, 128, 127, 120], label: 'GME'}
      ];
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
    {data: this.dataArray, label: 'Series A', fill:false},
    {data: [130, 120, 130, 120, 130, 120, 130], label: 'Series B'},
    {data: [120, 125, 122, 130, 128, 127, 120], label: 'Series C'}
  ];

  ngOnInit(): void {
    this.chartService.getData().subscribe(data => {
      this.recievedData = data; 
      console.log(data)
    })
  }

}
