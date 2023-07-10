import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { BoardPageComponent } from './components/board-page/board-page.component';

const routes: Routes = [
  {path: 'home' , component: HomePageComponent},
  {path: '', redirectTo: 'home', pathMatch: "full"},
  {path: 'board/:id' , component: BoardPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
