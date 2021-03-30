import { UserServiceService } from './../../services/user-service.service';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/models/user.model';
import { Component, OnInit } from '@angular/core'
import { LoginTemplate } from 'src/app/models/login-template.model';
import { pipe } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
}) 
export class LoginComponent implements OnInit {

  public loginTemplate: LoginTemplate = new LoginTemplate('','');

  constructor(public appComponent: AppComponent, private userService: UserServiceService) { 
    this.errorCode = document.getElementById('errorText');
  }

  ngOnInit(): void {
    this.appComponent.clearUser();
  }
  
  errorCode: HTMLElement|null;

  public login(): void {
    this.errorCode = document.getElementById('errorText');
    console.log(this.loginTemplate)
    this.userService.login(this.loginTemplate?.username,this.loginTemplate?.password).subscribe(user=>{
      console.log(user);
      
      if(!user){
        document.getElementById('errorText')?.removeAttribute('hidden');
      }
      else if(user.password == this.loginTemplate.password)
      {
        this.appComponent.user = user;
        this.loggedIn()
      }
      else if(user.password!=this.loginTemplate.password)
        console.log("incorrect Password")
        console.log(this.errorCode)
        this.errorCode?.removeAttribute('hidden');
        if(this.errorCode!=null)
        {
          
          this.errorCode.innerHTML = "Incorrect password";
        }
      });

  }
  
  public registerTeacher(){
    this.userService.registerTeacher(this.loginTemplate).subscribe(data=>
      {
        this.login();
      })

  }

  loggedIn(){
    console.log(this.appComponent.user)
    localStorage.setItem('user', JSON.stringify(this.appComponent.user));
    if (this.appComponent.user?.userRole == 'Teacher') {
      
        if (!this.appComponent.user.game||this.appComponent.user?.game.gameId == null || this.appComponent.user?.game.gameId == 0) {
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
