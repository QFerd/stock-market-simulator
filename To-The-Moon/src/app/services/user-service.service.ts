import { TO_THE_MOON_URL } from './../../environments/environment';
import { ClientMessage } from './../models/client-message.model';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }
  constructor(private http: HttpClient) { }

  public login(username:string|undefined, password:string|undefined): Observable<User> {
    let loginTemplate = {
      'username': username,
      'password': password
    }
    var output = this.http.post<User>(`${TO_THE_MOON_URL}login`, loginTemplate , this.httpOptions);
    console.log(output);
    output.subscribe(data => {console.log(data);localStorage.setItem('User',JSON.stringify(data))})
    return output;
  }
}
