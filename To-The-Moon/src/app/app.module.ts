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
import { PositionsComponent } from './components/positions/positions.component';
import { StockComponent } from './components/stock/stock.component';
import { PositionDetailComponent } from './components/position-detail/position-detail.component';
import { RegistryComponent } from './components/teacher/registry/registry.component';
import { ClassroomComponent } from './components/teacher/registry/classroom/classroom.component';
import { StudentsComponent } from './components/teacher/registry/students/students.component';
import { TestChartingComponent } from './test-charting/test-charting.component';
import { GoogleChartsModule } from 'angular-google-charts';
import { ChartsModule } from 'ng2-charts';
import { MyBarChartComponent } from './my-bar-chart/my-bar-chart.component';




@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    HomeComponent,
    TeacherComponent,
    TeacherHomeComponent,
    PositionsComponent,
    StockComponent,
    PositionDetailComponent,
    RegistryComponent,
    ClassroomComponent,
    StudentsComponent,
    TestChartingComponent,
    MyBarChartComponent,
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserModule, GoogleChartsModule,
    ChartsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
}
