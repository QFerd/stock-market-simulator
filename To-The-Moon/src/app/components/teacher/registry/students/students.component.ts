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
  
  constructor(public appComponent:AppComponent) { }

  ngOnInit(): void {
  }

  UserToSend: User = { username: '', id: 0, game: { game_game_id: 0, phase: 0, startDate: "04/30/2009" }, portfolio: null, userRole: 'Student' };

  

}
