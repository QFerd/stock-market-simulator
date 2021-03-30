import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ALPHAVANTAGE_URL } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class StockService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
  constructor(private http:HttpClient) { }

  // getArrayOfPositions():A

  getStockBySymbol(symbol:string,timeStart:string): Observable<string>{
    return this.http.get<string>(`${ALPHAVANTAGE_URL}&function=TIME_SERIES_MONTHLY&symbol=${symbol}`);
  }


}
