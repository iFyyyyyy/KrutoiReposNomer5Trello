import { style } from '@angular/animations';
import { AppRoutingModule } from './../../app-routing.module';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NbCardComponent } from '@nebular/theme';
import { Board } from 'src/app/Entities/Board';
import {
  CdkDragDrop,
  CdkDrag,
  CdkDropList,
  CdkDropListGroup,
  moveItemInArray,
  transferArrayItem,
} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {

  board: Board = new Board;
  boards: Board[];

  constructor(private router: Router){
    this.boards = [];
  }

      Testboards = [
      {id: 0, name: "BoardName1", description: "BoardDescription1", user: "user1", privacy: "public"},
      {id: 1, name: "BoardName2", description: "BoardDescription2", user: "user2", privacy: "public"},
      {id: 2, name: "BoardName3", description: "BoardDescription3", user: "user3", privacy: "public"},
      {id: 3, name: "BoardName4", description: "BoardDescription4", user: "user4", privacy: "public"},
      // {id: 4, name: "BoardName5", description: "BoardDescription5", user: "user5", privacy: "public"},
      // {id: 5, name: "BoardName6", description: "BoardDescription6", user: "user6", privacy: "public"},
      // {id: 5, name: "BoardName7", description: "BoardDescription6", user: "user6", privacy: "public"},
      // {id: 5, name: "BoardName8", description: "BoardDescription6", user: "user6", privacy: "public"},
      // {id: 5, name: "BoardName9", description: "BoardDescription6", user: "user6", privacy: "public"},
      // {id: 5, name: "BoardName10", description: "BoardDescription6", user: "user6", privacy: "public"},
      // {id: 5, name: "BoardName11", description: "BoardDescription6", user: "user6", privacy: "public"},
      // {id: 5, name: "BoardName12", description: "BoardDescription6", user: "user6", privacy: "public"},
    ];

    newFunction(id: number){
      this.router.navigate(["board"]);
    };

    onMouseEnter(card: NbCardComponent) {
      card.accent = "info"; //= "20px" ;
    }

    onMouseOut(card: NbCardComponent) {
      card.accent = "basic";
      //card.style.marginTop = "0px" ;
    }

      drop(event: CdkDragDrop<any[]>) {
        if (event.previousContainer === event.container) {
          moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
          transferArrayItem(
            event.previousContainer.data,
            event.container.data,
            event.previousIndex,
            event.currentIndex,
          );
        }
      };


}
