import { AppComponent } from 'src/app/app.component';
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
  loginUser: User = {password:'', username: '', id: 0, game: null, portfolio: null, userRole: '' };

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
  teacherToRegister:User = {game:null,id:0,password:'',portfolio:null,userRole:'Teacher',username:''}
  public registerTeacher(loginTemplate: LoginTemplate): Observable<string> {
    this.teacherToRegister.username=loginTemplate.username;
    this.teacherToRegister.password=loginTemplate.password;
    return this.http.post<string>(`${TO_THE_MOON_URL}register`, this.teacherToRegister, this.httpOptions)
  }

  public setUser(userToSend: User): Observable<String> {
    
    
    return this.http.post<String>(`${TO_THE_MOON_URL}setUser`, userToSend, this.httpOptions)
  
    
  }

  public registerUser(userToSend:User): Observable<String> {
    return this.http.post<String>(`${TO_THE_MOON_URL}register`, userToSend, this.httpOptions)

  }

}
