import { UserServiceService } from './../../services/user-service.service';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/models/user.model';
import { Component, OnInit } from '@angular/core'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
}) 
export class LoginComponent implements OnInit {

  public loginTemplate?: LoginTemplate;

  constructor(public appComponent: AppComponent, private userService: UserServiceService) { 
    
  }

  ngOnInit(): void {
  }

  public login(): void {
    this.userService.login(this.loginTemplate?.username,this.loginTemplate?.password)
  }
  

}
type LoginTemplate = { username:string; password:string }