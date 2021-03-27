import { TO_THE_MOON_URL } from './../../environments/environment';
import { ClientMessage } from './../models/client-message.model';
import { Injectable, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { USERS } from '../mock-user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService implements OnInit {
  users=USERS;
  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  public login(username:string|undefined, password:string|undefined): User |undefined {
    let loginTemplate = {
      'username': username,
      'password': password
    }
    
    var output = this.users.find(data => data.username==loginTemplate.username);
    localStorage.setItem('user', JSON.stringify(output));
    return output;
    //this.http.post<User>(`${TO_THE_MOON_URL}login`, loginTemplate , this.httpOptions);
    // console.log(output);
    // //output.subscribe(data => {console.log(data);localStorage.setItem('User',JSON.stringify(data))})
    // return output;
  }
}
