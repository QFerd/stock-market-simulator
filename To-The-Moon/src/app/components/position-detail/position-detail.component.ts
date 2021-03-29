
import { Component, OnInit, Input } from '@angular/core';
import { Position } from '../../models/position.model';

import { StockService } from 'src/app/services/stock.service';


@Component({
  selector: 'app-position-detail',
  templateUrl: './position-detail.component.html',
  styleUrls: ['./position-detail.component.css']
})
export class PositionDetailComponent implements OnInit {
  @Input() position: Position|undefined;

  constructor(public stockService:StockService) {
    this.position = {portfolio_id_fk:0,position_id:0,portfolio_portfolio_id:0,quantity:0,stock_symbol:''};
   }

  ngOnInit() {
    if(this.position!=undefined)
      console.log(this.stockService.getStockBySymbol(this.position.stock_symbol,"2020-10-05"))
  }

}