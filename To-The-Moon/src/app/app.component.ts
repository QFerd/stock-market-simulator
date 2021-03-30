import { Component, Input, OnInit } from '@angular/core';
// import { USERS } from './mock-user';
// import { Portfolio } from './models/portfolio.model';
// import { Position } from './models/position.model';

import { User } from './models/user.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'To-The-Moon';
  constructor() {

    
  }
  ngOnInit(): void {
  
    var userInStorage
    userInStorage = localStorage.getItem('user');

    if (userInStorage != null) {
      this.user = JSON.parse(userInStorage);
    } else {
      this.user = { username: '', userRole: '', id: 0, portfolio: null, game: null};
    } 
  }


   user: User = {id:0,portfolio: null,userRole:'',username:'',game: null};


  public makeStudent():void {
    this.user.userRole='Student';
  }

  public makeTeacher(): void {
    this.user.userRole='Teacher';
  }


  public clearUser():void{
    localStorage.clear();
    this.user = { id: 0, portfolio: null, userRole: '', username: '', game: null};
  }
}
