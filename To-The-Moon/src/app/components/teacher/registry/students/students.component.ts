import { Component, OnInit } from '@angular/core';
import { USERS } from '../../../../mock-user'
import { User } from "../../../../user"

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  users = USERS;
  selectedUser?: User;

  constructor() { }

  ngOnInit(): void {
  }

  

}
