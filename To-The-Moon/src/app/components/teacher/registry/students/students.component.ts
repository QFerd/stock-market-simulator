import { UserServiceService } from 'src/app/services/user-service.service';
import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/models/user.model';
import { USERS } from '../../../../mock-user'

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  users = USERS;
  selectedUser?: User;
  
  constructor(public appComponent:AppComponent, private userServiceService: UserServiceService) { }

  ngOnInit(): void {
  }

  UserToSend: User = { username: '', id: 0, game: this.appComponent.user.game , portfolio: null, userRole: 'Student' };
  sendtheUser(): void {
    this.userServiceService.setUser(this.UserToSend)
  }
  

}
