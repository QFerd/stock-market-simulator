import { StudentsComponent } from './components/teacher/registry/students/students.component';
import { ClassroomComponent } from './components/teacher/registry/classroom/classroom.component';
import { RegistryComponent } from './components/teacher/registry/registry.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TeacherComponent } from './components/teacher/teacher.component';
import { TeacherHomeComponent } from './components/teacher/teacher-home/teacher-home.component';
import { PositionsComponent } from './components/positions/positions.component';
import { StockComponent } from './components/stock/stock.component';
import { TestChartingComponent } from './test-charting/test-charting.component';
import { MyBarChartComponent } from './my-bar-chart/my-bar-chart.component';

const routes: Routes = [
  { path: "", redirectTo: 'login', pathMatch: 'full' },
   { path: "login", component: LoginComponent },
   { path: "teacher", component:TeacherComponent, children:[
     {path:"home", component:TeacherHomeComponent}, 
     {path: "registry", component:RegistryComponent, children: [
       {path: "classroom", component:ClassroomComponent},
       {path: "students", component:StudentsComponent}
     ]}
   ] },
   { path: "home",component:HomeComponent},
   { path: "postions", component:PositionsComponent},
   { path:"stock/*",component:StockComponent},
   {path:"testingChart",component:TestChartingComponent},
   {path: 'bar-chart', component: MyBarChartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
