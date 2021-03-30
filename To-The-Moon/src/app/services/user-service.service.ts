import { TO_THE_MOON_URL } from './../../environments/environment';
import { ClientMessage } from './../models/client-message.model';
import { Injectable, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { USERS } from '../mock-user';
import { LoginTemplate } from '../models/login-template.model';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService implements OnInit {
  users = USERS;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  loginUser: User = { username: '', id: 0, game: { game_game_id: 0, phase: 0, startDate: "04/30/2009" }, portfolio: { portfolio_id: 0, cash_value: 0, stock_value: 0, total_value: 0, positions: [{ position_id: 0, quantity: 0, stock_symbol: 'aarp', portfolio_portfolio_id: 0, portfolio_id_fk: 0 }] }, userRole: '' };

  public login(username: string | undefined, password: string | undefined): Observable<User> {
    let loginTemplate = {
      'username': username,
      'password': password
    }

    // var output = this.users.find(data => data.username==loginTemplate.username);
    // localStorage.setItem('user', JSON.stringify(output));
    // return output;this.loginUser ={this.loginUser.username=data.username,this.loginUser.id=data.id,this.loginUser.game_game_id=data.game_game_id,this.loginUser.role=data.role}


    //output.subscribe(data => {console.log(data);localStorage.setItem('User',JSON.stringify(data))}).subscribe(data=>{console.log(data);this.loginUser=data; return this.loginUser;}
    return this.http.post<User>(`${TO_THE_MOON_URL}login`, loginTemplate, this.httpOptions);
  }

  public registerTeacher(loginTemplate: LoginTemplate): User {

    var index = this.users.push({ username: loginTemplate.username, id: this.users.length + 1, game: { game_game_id: 0, phase: 0, startDate: "2010/01/01" }, portfolio: { portfolio_id: 0, cash_value: 0, stock_value: 0, total_value: 0, positions: [{ position_id: 0, quantity: 0, stock_symbol: 'aarp', portfolio_portfolio_id: 0, portfolio_id_fk: 0 }] }, userRole: "Teacher" });
    var output = this.users[index - 1];
    localStorage.setItem('user', JSON.stringify(output));
    return output;
  }
}
