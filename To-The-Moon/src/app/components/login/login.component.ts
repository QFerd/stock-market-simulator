import { UserServiceService } from './../../services/user-service.service';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/models/user.model';
import { Component, OnInit } from '@angular/core'
import { LoginTemplate } from 'src/app/models/login-template.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
}) 
export class LoginComponent implements OnInit {

  public loginTemplate: LoginTemplate = new LoginTemplate('','');

  constructor(public appComponent: AppComponent, private userService: UserServiceService) { 
  }

  ngOnInit(): void {
    this.appComponent.clearUser();
  }
  
  public login(): void {
    console.log(this.loginTemplate)
    this.userService.login(this.loginTemplate?.username,this.loginTemplate?.password).subscribe(user=>{console.log(user);this.appComponent.user = user;this.loggedIn()});

  }
  
  public registerTeacher(){
    var currentUser= this.userService.registerTeacher(this.loginTemplate);
    if(currentUser?.userRole=='Teacher')
      window.location.href = "teacher/registry/classroom";
    else
      alert("Something went wrong");
  }

  loggedIn(){
    console.log(this.appComponent.user)
    localStorage.setItem('user', JSON.stringify(this.appComponent.user));
    if (this.appComponent.user?.userRole == 'Teacher') {
      if (this.appComponent.user?.game.game_game_id == null || this.appComponent.user?.game.game_game_id == 0) {
        window.location.href = "teacher/registry/classroom";
      } else {
        window.location.href = 'teacher/home';
      }

    }
    else if (this.appComponent.user?.userRole == 'Student') {
      window.location.href = 'home';
    }
  }

}
