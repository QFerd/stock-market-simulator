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

  public loginTemplate: LoginTemplate;

  constructor(public appComponent: AppComponent, private userService: UserServiceService) { 
    this.loginTemplate = new LoginTemplate('','');
  }

  ngOnInit(): void {
  }

  public login(): void {
    this.userService.login(this.loginTemplate?.username,this.loginTemplate?.password)
    console.log(this.loginTemplate)

    if(this.appComponent.user.role=='Teacher')
    {
      window.location.href='teacher/home';
    }
    else if (this.appComponent.user.role=='Student'){
      window.location.href='home';
    }
  }
  

}
