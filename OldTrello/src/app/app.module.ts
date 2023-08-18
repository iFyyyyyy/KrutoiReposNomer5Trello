
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
import { CreateBoardWrapperComponent } from './components/wrappers/board-wrappers/create-board-wrapper/create-board-wrapper.component';
import { UpdateBoardWrapperComponent } from './components/wrappers/board-wrappers/update-board-wrapper/update-board-wrapper.component';
import { DeleteBoardWrapperComponent } from './components/wrappers/board-wrappers/delete-wrapper/delete-wrapper.component';
import { CreateColumnWrapperComponent } from './components/wrappers/column-wrappers/create-column-wrapper/create-column-wrapper.component';
import { UpdateColumnWrapperComponent } from './components/wrappers/column-wrappers/update-column-wrapper/update-column-wrapper.component';
import { DeleteColumnWrapperComponent } from './components/wrappers/column-wrappers/delete-column-wrapper/delete-column-wrapper.component';
import { CreateTaskWrapperComponent } from './components/wrappers/task-wrappers/create-task-wrapper/create-task-wrapper.component';
import { UpdateTaskWrapperComponent } from './components/wrappers/task-wrappers/update-task-wrapper/update-task-wrapper.component';
import { DeleteTaskWrapperComponent } from './components/wrappers/task-wrappers/delete-task-wrapper/delete-task-wrapper.component';
//import { NbPasswordAuthStrategy, NbAuthModule } from '@nebular/auth';
import { LoginComponent } from './components/authorization/login/login.component';
import { LogoutComponent } from './components/authorization/logout/logout.component';
import { RegistrationPageComponent } from './components/authorization/registration-page/registration-page.component';
//import { TestdragdropComponent } from './components/testdragdrop/testdragdrop.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    HomePageComponent,
    BoardPageComponent,
    CreateBoardWrapperComponent,
    UpdateBoardWrapperComponent,
    DeleteBoardWrapperComponent,
    CreateColumnWrapperComponent,
    UpdateColumnWrapperComponent,
    DeleteColumnWrapperComponent,
    CreateTaskWrapperComponent,
    UpdateTaskWrapperComponent,
    DeleteTaskWrapperComponent,
    LoginComponent,
    LogoutComponent,
    RegistrationPageComponent,

//    TestdragdropComponent

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
    // NbAuthModule.forRoot({
    //   strategies: [
    //     NbPasswordAuthStrategy.setup({
    //       name: 'username',
    //     }),
    //   ],
    //   forms: {},
    // }),

  ],
  providers: [NbSidebarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
