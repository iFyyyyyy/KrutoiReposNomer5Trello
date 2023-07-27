import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NbDialogModule, NbCardModule, NbSelectModule, NbThemeModule, NbContextMenuModule, NbInputModule, NbSearchModule, NbFormFieldModule, NbUserModule, NbLayoutModule, NbIconModule, NbSidebarModule, NbMenuModule, NbActionsModule, NbButtonModule, NbSidebarService } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { NavigationComponent } from './components/navigation/navigation.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { BoardPageComponent } from './components/board-page/board-page.component';
import {DragDropModule} from '@angular/cdk/drag-drop';
import { NbListModule } from '@nebular/theme';
import {MatCardModule} from '@angular/material/card';
import { FormsModule } from '@angular/forms';



import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreateBoardWrapperComponent } from './components/wrappers/create-board-wrapper/create-board-wrapper.component';
import { UpdateBoardWrapperComponent } from './components/wrappers/update-board-wrapper/update-board-wrapper.component';
import { DeleteWrapperComponent } from './components/wrappers/delete-wrapper/delete-wrapper.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    HomePageComponent,
    BoardPageComponent,
    CreateBoardWrapperComponent,
    UpdateBoardWrapperComponent,
    DeleteWrapperComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
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
    NbButtonModule,
    NbSearchModule,
    NbInputModule,
    NbContextMenuModule,
    NbSelectModule,

    FormsModule,

    DragDropModule,
    NbListModule,
    MatCardModule,
    NbDialogModule.forRoot(),

    HttpClientModule,
    BrowserAnimationsModule,
    NbThemeModule.forRoot({ name: 'default' }),



  ],
  providers: [NbSidebarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
