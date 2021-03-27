import { Component, OnInit, Input } from '@angular/core';
import { Position } from './../position';


@Component({
  selector: 'app-position-detail',
  templateUrl: './position-detail.component.html',
  styleUrls: ['./position-detail.component.css']
})
export class PositionDetailComponent implements OnInit {

  @Input() position?: Position;

  constructor() { }

  ngOnInit(): void {
  }

}
