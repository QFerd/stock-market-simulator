import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Game } from 'src/app/models/game.model';
import { GameService } from 'src/app/services/game.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-classroom',
  templateUrl: './classroom.component.html',
  styleUrls: ['./classroom.component.css']
})
export class ClassroomComponent implements OnInit {

  constructor(public appComponent:AppComponent, public gameService:GameService, public userService:UserServiceService) { this.date=new Date(Date.now())}

  ngOnInit(): void {
  }
  date:Date;
  gameToSend: Game = { gameId: 0, phase: 1, startDate: '' }
  createClassroom(): void {
    console.log(this.date.toString())
    if(this.date!=null)
      {
        this.gameToSend.startDate=this.date.toString();
        this.gameService.registerGame(this.gameToSend).subscribe(index =>{
        if(this.date!=null)
        {  
          this.appComponent.user.game = {gameId:index, phase: 1, startDate: this.date.toString()};
          console.log(this.appComponent.user);
          this.userService.setUser(this.appComponent.user).subscribe(data => {
            console.log(this.appComponent.user);
            this.appComponent.setUser(this.appComponent.user);
            localStorage.setItem("user",JSON.stringify(this.appComponent.user));
            window.location.href = "teacher/registry/students"
          });
          
      }
      });
    }

  }
}


