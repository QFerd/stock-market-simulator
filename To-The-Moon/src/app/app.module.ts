import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { User } from './models/user.model';
import { HomeComponent } from './components/home/home.component';
import { TeacherHomeComponent } from './components/teacher/teacher-home/teacher-home.component';
import { TeacherComponent } from './components/teacher/teacher.component';
import { PositionsComponent } from './positions/positions.component';
import { StockComponent } from './components/stock/stock.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    HomeComponent,
    TeacherComponent,
    TeacherHomeComponent,
    PositionsComponent,
    StockComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
}
