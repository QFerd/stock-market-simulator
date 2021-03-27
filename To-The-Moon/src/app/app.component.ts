import { Component } from '@angular/core';
import { USERS } from './mock-user';
import { User } from './models/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'To-The-Moon';
  constructor() {
    var userInStorage
    userInStorage = localStorage.getItem('User');
    tempUser:USERS
    if(userInStorage!=null)
    {
      this.user = JSON.parse(userInStorage);
    } else {
      this.user = {username:'',role:'',id: 0,portfolio_id:0,userrole_id:0};
    }
    
  }

  user: User 


  public makeStudent():void {
    this.user.role='Student';
  }

  public makeTeacher(): void {
    this.user.role='Teacher';
  }
}
