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
      this.user = { username: '', userRole: '', id: 0, portfolio: { portfolio_id: 0, cash_value: 0, stock_value: 0, total_value: 0, positions: [{ position_id: 0, quantity: 0, stockSymbol: 'aarp', portfolio_portfolio_id: 0, portfolio_id_fk: 0 }] }, game: { game_game_id: 0, phase: 0, startDate: "2010/01/01" }};
    } 
  }


   user: User = {id:0,portfolio: { portfolio_id: 0, cash_value: 0, stock_value: 0, total_value: 0, positions: [] },userRole:'',username:'',game: { game_game_id: 0, phase: 0, startDate: "2010/01/01" }};


  public makeStudent():void {
    this.user.userRole='Student';
  }

  public makeTeacher(): void {
    this.user.userRole='Teacher';
  }


  public clearUser():void{
    localStorage.clear();
    this.user = { id: 0, portfolio: { portfolio_id: 0, cash_value: 0, stock_value: 0, total_value: 0, positions: [{ position_id: 0, quantity: 0, stockSymbol: 'aarp', portfolio_portfolio_id: 0, portfolio_id_fk: 0 }] }, userRole: '', username: '', game: { game_game_id: 0, phase: 0, startDate: "2010/01/01" }};
  }
}
