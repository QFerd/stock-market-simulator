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

  public dataArray: any = [];

  public populateTable() {
    var date = this.date;
    var APIDataArr = []
    console.log(this.recievedData["Time Series (Daily)"][`${date}-05`]["4. close"]);
    // var timeSeries = this.recievedData["Time Series (Daily)"]
    // var i =0;
    // for (var e in timeSeries) {
    //   // maybe: (parseInt(date.slice(5,7)) to determine date
    //   if (i < 5) {
    //     APIDataArr.push(parseInt(e[<any>"4. close"]));
    //     i++;

    //   } else {
    //     break;
    //   }

    // }
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
        {data: this.dataArray, label: 'Daily Time Series'},
        {data: [130, 120, 130, 120, 130, 120, 130], label: 'Series B'},
        {data: [120, 125, 122, 130, 128, 127, 120], label: 'Series C'}
      ];
    
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
    {data: this.dataArray, label: 'Series A'},
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
