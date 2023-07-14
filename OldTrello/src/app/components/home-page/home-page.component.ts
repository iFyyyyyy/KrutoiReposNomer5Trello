import { style } from '@angular/animations';
import { AppRoutingModule } from './../../app-routing.module';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NbCardComponent, NbMenuItem } from '@nebular/theme';
import { Board } from 'src/app/Entities/Board';
import {
  CdkDragDrop,
  CdkDrag,
  CdkDropList,
  CdkDropListGroup,
  moveItemInArray,
  transferArrayItem,
} from '@angular/cdk/drag-drop';
import { BoardServiceService } from 'src/app/service/board-service.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {

  board: Board = new Board;
  boards: Board[];


  // USER ID
  id: number = 1;

  constructor(private router: Router, private boardService: BoardServiceService){
    this.boards = [];
  }

  boardOptions: NbMenuItem[] = [
    {
      title: 'Edit Board',
      icon: 'edit-outline',
    },
    {
      title: 'Delete Board',
      icon: 'trash-2-outline',
     // link: 'home',
    },
  ];

  menuOptions: NbMenuItem[] = [
    {
      title: 'Create New Board',
      icon: 'plus-square-outline',
    },

  ];



    //   Testboards = [
    //   {id: 0, name: "BoardName1", description: "BoardDescription1", user: "user1", isPrivate: "public"},
    //   {id: 1, name: "BoardName2", description: "BoardDescription2", user: "user2", isPrivate: "public"},
    //   {id: 2, name: "BoardName3", description: "BoardDescription3", user: "user3", isPrivate: "public"},
    //   {id: 3, name: "BoardName4", description: "BoardDescription4", user: "user4", isPrivate: "public"},
    // ];

    ngOnInit(){
      this.boardService.getAllBoards(this.id).subscribe((result: Board[]) => {
        console.log(result);
        this.boards = result;

      })
    }



     applyFilter(event: Event){};
    // applyFilter(event: Event) {
    //   const filterValue = (event.target as HTMLInputElement).value;
    //   this.board.boardName.filter = filterValue.trim().toLowerCase();
    //   }
    // }


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
