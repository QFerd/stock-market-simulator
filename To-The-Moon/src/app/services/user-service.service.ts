import { TO_THE_MOON_URL } from './../../environments/environment';
import { ClientMessage } from './../models/client-message.model';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }
  constructor(private http: HttpClient) { }

  public login(username:string|undefined, password:string|undefined): Observable<ClientMessage> {
    let loginTemplate = {
      'username': username,
      'password': password
    }
    return this.http.post<ClientMessage>(`${TO_THE_MOON_URL}login`, loginTemplate , this.httpOptions)


  }
}
