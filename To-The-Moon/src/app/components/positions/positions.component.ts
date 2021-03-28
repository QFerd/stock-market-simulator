import { PositionService } from './../../services/position.service';
import { Component, OnInit } from '@angular/core';
import { POSITIONS } from '../../mock-positions'

@Component({
  selector: 'app-positions',
  templateUrl: './positions.component.html',
  styleUrls: ['./positions.component.css']
})
export class PositionsComponent implements OnInit {

  positions = POSITIONS;

  constructor(private positionService: PositionService) { }

  ngOnInit(): void {
  }

}