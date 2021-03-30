import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/game.model';
import { User } from '../models/user.model';
import { TO_THE_MOON_URL } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
  constructor(private http: HttpClient) { }

  registerGame(game:Game):Observable<number> {
    console.log(game)
    return this.http.post<number>(`${TO_THE_MOON_URL}setGame`,game);
  }

  nextPhase(game:Game):Observable<Game> {
    console.log(game)
    return this.http.put<Game>(`${TO_THE_MOON_URL}updateGame`,game)
  }
  getGamePhase(user: User | undefined):Observable<Game> {
    return this.http.post<Game>(`${TO_THE_MOON_URL}getGamer`,user);
  }
}
