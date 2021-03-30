import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { ALPHAVANTAGE_URL } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChartService {

  constructor(private http: HttpClient) { }

  stockSymbol: String = "IBM";

  public getData(): Observable<any> {
    console.log("hi")
    return this.http.get(`${ALPHAVANTAGE_URL}&function=TIME_SERIES_DAILY&symbol=IBM`)
    //https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=demo
  }
}
