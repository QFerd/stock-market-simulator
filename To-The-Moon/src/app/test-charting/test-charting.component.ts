import { Component, OnInit } from '@angular/core';
import { ChartType } from 'angular-google-charts';

@Component({
  selector: 'app-test-charting',
  templateUrl: './test-charting.component.html',
  styleUrls: ['./test-charting.component.css']
})
export class TestChartingComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  title = 'Browser market shares at a specific website, 2014';
  type:ChartType = ChartType.PieChart;
  data = [
    ['Firefox', 45.0],
    ['IE', 26.8],
    ['Chrome', 12.8],
    ['Safari', 8.5],
    ['Opera', 6.2],
    ['Others', 0.7]
  ];
  columnNames = ['Browser', 'Percentage'];
  options = {
  };
  width = 550;
  height = 400;
}
