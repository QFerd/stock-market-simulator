import { AppComponent } from './../../../app.component';
import { Component, OnInit } from '@angular/core';
import { User } from './../../../models/user.model';
import { Game } from './../../../models/game.model'

@Component({
  selector: 'app-teacher-home',
  templateUrl: './teacher-home.component.html',
  styleUrls: ['./teacher-home.component.css']
})
export class TeacherHomeComponent implements OnInit {

  constructor(private appComponent: AppComponent) {
    if (this.appComponent.user.game)
      this.game = this.appComponent.user.game

   }

  user: User =  this.appComponent.user;
  game: Game = {game_game_id: 0, phase: 0, startDate:''};

  ngOnInit(): void {
  }

  nextPhase() {
    
  }

  startGame() {
    this.appComponent.user.game?.phase
  }

}
