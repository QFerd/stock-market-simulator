import { Observable, of } from 'rxjs';
import { POSITIONS } from './../mock-positions';
import { Position } from '../models/position.model';
import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';


@Injectable({
  providedIn: 'root'
})
export class PositionService {

  constructor() { }


  // getPositions(portfolio_id:number): Observable<Position[]> {
  //   const positions = of(POSITIONS.filter(p=>p.portfolio_id_fk == portfolio_id));
  //   return positions;
  // }
}
