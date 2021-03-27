import { Observable, of } from 'rxjs';
import { POSITIONS } from './../mock-positions';
import { Position } from './../position';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class PositionService {

  constructor() { }


  getPositions(): Observable<Position[]> {
    const positions = of(POSITIONS);
    return positions;
  }
}
