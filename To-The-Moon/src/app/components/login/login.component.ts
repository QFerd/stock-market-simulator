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
    var currentUser = this.userService.login(this.loginTemplate?.username,this.loginTemplate?.password);
    console.log(currentUser)

    if(currentUser?.role=='Teacher')
    {
      if (currentUser?.game_game_id == null || currentUser?.game_game_id == 0 ){
        window.location.href="teacher/registry/classroom";
      } else {
        window.location.href='teacher/home';
      }
      
    }
    else if (currentUser?.role=='Student'){
      window.location.href='home';
    }
  }
  
  public registerTeacher(){

  }

}
