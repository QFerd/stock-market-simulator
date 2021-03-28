import { Position } from '../../models/position';
import { PositionService } from './../../services/position.service';
import { Component, OnInit } from '@angular/core';
import { POSITIONS } from '../../mock-positions'
import { AppComponent } from 'src/app/app.component';


@Component({
  selector: 'app-positions',
  templateUrl: './positions.component.html',
  styleUrls: ['./positions.component.css']
})
export class PositionsComponent implements OnInit {

  selectedPosition?: Position;

  positions: Position[] = [];

  constructor(private positionService: PositionService, private appComponent:AppComponent) { }

  ngOnInit(): void {
    this.getPositions();
  }

  onSelect(position: Position): void {
    this.selectedPosition = position;
  }

  getPositions(): void {
    this.positionService.getPositions(this.appComponent.user.portfolio_id)
        .subscribe(positions => this.positions = positions);
  }

}
