import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NbCardModule, NbThemeModule, NbFormFieldModule, NbUserModule, NbLayoutModule, NbIconModule, NbSidebarModule, NbMenuModule, NbActionsModule, NbSidebarService } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { NavigationComponent } from './components/navigation/navigation.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { BoardPageComponent } from './components/board-page/board-page.component';
import {DragDropModule} from '@angular/cdk/drag-drop';
import { NbListModule } from '@nebular/theme';
import {MatCardModule} from '@angular/material/card';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    HomePageComponent,
    BoardPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NbThemeModule.forRoot({ name: 'default' }),
    NbLayoutModule,
    NbEvaIconsModule,
    NbActionsModule,
    NbLayoutModule,
    NbMenuModule.forRoot(),
    NbIconModule,
    NbSidebarModule.forRoot(),
    NbSidebarModule,
    NbFormFieldModule,
    NbUserModule,
    NbCardModule,

    DragDropModule,
    NbListModule,
    MatCardModule,


  ],
  providers: [NbSidebarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
