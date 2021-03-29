import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-classroom',
  templateUrl: './classroom.component.html',
  styleUrls: ['./classroom.component.css']
})
export class ClassroomComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  createClassroom(): void {
    window.location.href = "teacher/registry/students"
  }

}
