import { Position } from '../../models/position.model';
import { PositionService } from './../../services/position.service';
import { Component, OnInit } from '@angular/core';
import { POSITIONS } from '../../mock-positions'
import { AppComponent } from 'src/app/app.component';
import { StockService } from 'src/app/services/stock.service';
import { templateJitUrl } from '@angular/compiler';


@Component({
  selector: 'app-positions',
  templateUrl: './positions.component.html',
  styleUrls: ['./positions.component.css']
})
export class PositionsComponent implements OnInit {

  selectedPosition?: Position;

  positions: Position[] = [];
  public tempHolder:any;
  constructor(private stockService:StockService,private positionService: PositionService, private appComponent:AppComponent) { }

  ngOnInit(): void {
    this.getPositions();
  }

  onSelect(position: Position): void {
    this.selectedPosition = position;
  }
  data:Object={};
  testing(){
    
    console.log(this.stockService.getStockBySymbol('AMC','2020-03-15').subscribe(inputted=>this.tempHolder=inputted));
    console.log(this.tempHolder)
    console.log(this.tempHolder['Meta Data']);
    console.log(this.tempHolder['Meta Data']['2. Symbol']);
  }

  getPositions(): void {
    if (this.appComponent.user.portfolio)
      this.positionService.getPositions(this.appComponent.user.portfolio.portfolio_id)
          .subscribe(positions => this.positions = positions);
  }

}
