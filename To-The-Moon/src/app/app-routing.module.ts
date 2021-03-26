import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TeacherComponent } from './components/teacher/teacher.component';
import { TeacherHomeComponent } from './components/teacher/teacher-home/teacher-home.component';
import { PositionsComponent } from './positions/positions.component';
import { StockComponent } from './components/stock/stock.component';

const routes: Routes = [
  { path: "", redirectTo: 'login', pathMatch: 'full' },
   { path: "login", component: LoginComponent },
   { path: "teacher", component:TeacherComponent, children:[
     {path:"home", component:TeacherHomeComponent}
   ] },
   { path: "home",component:HomeComponent},
   { path: "postions", component:PositionsComponent},
   { path:"stock/*",component:StockComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
