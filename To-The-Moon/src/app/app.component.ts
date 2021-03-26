import { Component } from '@angular/core';
import { User } from './models/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'To-The-Moon';
  constructor() {
    this.user= new User(0, '', '');
  }

  user: User 


  public makeStudent():void {
    this.user.role='Student';
  }

  public makeTeacher(): void {
    this.user.role='Teacher';
  }
}
