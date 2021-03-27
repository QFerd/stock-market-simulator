import { Component, OnInit, Input } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {


   user= this.appComponent.getUser(); 
  constructor(public appComponent: AppComponent ) { 
    
  }
 
  ngOnInit(): void {
    console.log(this.user);
    console.log(this.appComponent.user);
  }
}
