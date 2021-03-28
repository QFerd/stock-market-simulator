import { Component, Input, OnInit } from '@angular/core';
import { USERS } from './mock-user';
import { User } from './models/user.model';
import { UserServiceService } from './services/user-service.service';

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
      this.user = { username: '', role: '', id: 0, portfolio_id: 0, game_game_id:0 };
    }
  }

   user: User = {id:0,portfolio_id:0,role:'',username:'',game_game_id:0};


  public makeStudent():void {
    this.user.role='Student';
  }

  public makeTeacher(): void {
    this.user.role='Teacher';
  }

  public getUser():User{
    return this.user;
  }

  public clearUser():void{
    localStorage.clear();
  }
}
