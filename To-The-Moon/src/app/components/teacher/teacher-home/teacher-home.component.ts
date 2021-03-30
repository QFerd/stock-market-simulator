import { GameService } from 'src/app/services/game.service';
import { UserServiceService } from 'src/app/services/user-service.service';
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

  constructor(private appComponent: AppComponent, public GameService: GameService) {
    if (this.appComponent.user.game)
      {this.game = this.appComponent.user.game
        this.currentDate= this.appComponent.user.game.startDate;
      }

   }

  user: User =  this.appComponent.user;
  game: Game = {gameId: 0, phase: 0, startDate:''};
  currentDate:string = '';
  ngOnInit(): void {
  }

  nextPhase() {
    this.game.phase++;
    var dateInput = document.getElementById('in-game-date') as HTMLInputElement
    dateInput.stepUp();

   this.GameService.nextPhase(this.game).subscribe(data => {
     console.log(this.game)
     this.appComponent.user.game = this.game; 

     console.log(this.appComponent.user.game)
     localStorage.setItem('user', JSON.stringify(this.appComponent.user))
     
   })
    
  }

  startGame() {
    this.appComponent.user.game?.phase
  }

}
