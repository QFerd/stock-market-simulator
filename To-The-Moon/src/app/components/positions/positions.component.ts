import { Position } from './../../position';
import { PositionService } from './../../services/position.service';
import { Component, OnInit } from '@angular/core';
import { POSITIONS } from '../../mock-positions'


@Component({
  selector: 'app-positions',
  templateUrl: './positions.component.html',
  styleUrls: ['./positions.component.css']
})
export class PositionsComponent implements OnInit {

  selectedPosition?: Position;

  positions: Position[] = [];

  constructor(private positionService: PositionService) { }

  ngOnInit(): void {
    this.getPositions();
  }

  onSelect(position: Position): void {
    this.selectedPosition = position;
  }

  getPositions(): void {
    this.positionService.getPositions()
        .subscribe(positions => this.positions = positions);
  }

}
