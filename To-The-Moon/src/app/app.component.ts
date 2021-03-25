import { Component } from '@angular/core';
import { User } from './models/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'To-The-Moon';

  public user:User = new User('');

  public makeTeacher(){
    this.user.role="Teacher";
  }

  public makeStudent(){
    this.user.role="Student";
  }
}
