import { Component, OnInit } from '@angular/core';
import * as Chart from 'chart.js';
import { ChartType } from 'chart.js';
import { Observable } from 'rxjs';
import { ChartService } from '../chart.service';

@Component({
  selector: 'app-my-bar-chart',
  templateUrl: './my-bar-chart.component.html',
  styleUrls: ['./my-bar-chart.component.css']
})


export class MyBarChartComponent implements OnInit {

  constructor(private chartService: ChartService) { }

  public recievedData: any;

  public date: String = "2021-01";

  public dataArray = [];

  public populateTable() {
    var date = this.date;
    console.log(this.recievedData["Time Series (Daily)"][`${date}-05`]);
    
    
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
  public barChartData = [
    {data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A'},
    {data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B'}
  ];

  ngOnInit(): void {
    this.chartService.getData().subscribe(data => {
      this.recievedData = data; 
      console.log(data)
    })
  }

}
