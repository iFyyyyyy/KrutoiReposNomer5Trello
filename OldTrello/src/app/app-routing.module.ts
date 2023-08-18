import { NgModule } from '@angular/core';
import { RouterModule, Routes, CanActivateFn } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { BoardPageComponent } from './components/board-page/board-page.component';
import { LoginComponent } from './components/authorization/login/login.component';
import { LogoutComponent } from './components/authorization/logout/logout.component';
import { RegistrationPageComponent } from './components/authorization/registration-page/registration-page.component';
import { AuthGuard } from './auth-guard.guard';

const routes: Routes = [
  {path: 'home' , component: HomePageComponent, canActivate: [AuthGuard]},
  {path: '', redirectTo: 'home', pathMatch: "full"},
  {path: 'board/:id' , component: BoardPageComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'register', component: RegistrationPageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
