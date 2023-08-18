import { style } from '@angular/animations';
import { AppRoutingModule } from './../../app-routing.module';
import { Component, OnInit } from '@angular/core';
import { ResolveEnd, Router } from '@angular/router';
import { NbCardComponent, NbMenuItem, NbMenuService, NbDialogModule, NbDialogService } from '@nebular/theme';
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
import { CreateBoardWrapperComponent } from '../wrappers/board-wrappers/create-board-wrapper/create-board-wrapper.component';
import { ArrayDataSource } from '@angular/cdk/collections';
import { UpdateBoardWrapperComponent } from '../wrappers/board-wrappers/update-board-wrapper/update-board-wrapper.component';
import { DeleteBoardWrapperComponent } from '../wrappers/board-wrappers/delete-wrapper/delete-wrapper.component';
//import { DialogEditWrapperComponent } from '../wrappers/dialog-edit-wrapper/dialog-edit-wrapper.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {

  board: Board = new Board;
  boards: Board[];


  // USER ID
  userId: number = 1;

  constructor(
    private router: Router,
    private boardService: BoardServiceService,
    private menuService: NbMenuService,
    public dialog: NbDialogService
    ){
    this.boards = [];
  }

  selectedItem = '';

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



  ngOnInit(){
    this.getAllBoards();
  }


  getAllBoards(){
    this.boardService.getAllBoards().subscribe((boards: Board[]) => {
      console.log(boards);
      this.boards =  boards;
    })
  }

    // getSelectedItem() {
    //   this.menuService.getSelectedItem('menu')
    //     .pipe(takeUntil(this.destroy$))
    //     .subscribe( (menuBag) => {
    //       this.selectedItem = menuBag.item.title;
    //     });
    // }

  addNewBoard() {
    const dialogAddingNewBoard = this.dialog.open(CreateBoardWrapperComponent, {
      closeOnBackdropClick: true,
      context: {data: null},
    });
    dialogAddingNewBoard.onClose.subscribe(board => {
      if(board != null) {
        this.boardService.addNewBoard(board).subscribe(k=> {
          this.getAllBoards();
        });
      }
    });
  }

  updateBoard(board: Board) {
    const dialogUpdatingBoard = this.dialog.open(UpdateBoardWrapperComponent, {
      closeOnBackdropClick: true,
      context: {updatingBoard: board},
    });
    dialogUpdatingBoard.onClose.subscribe(resultBoard => {
      if (resultBoard != null){
        this.boardService.updateBoard(resultBoard).subscribe(k=> {
          this.getAllBoards();
        });
      }
    });
  }

    // updateBoardPosition(board: Board, newPosition: number){
    //   board.boardPosition = newPosition;
    //   this.boardService.updateBoard(board).subscribe(k => {
    //     this.getAllBoards(this.userId);
    //   })

    // }


  deleteBoard(board: Board) {
    const dialogUpdatingBoard = this.dialog.open(DeleteBoardWrapperComponent, {
      closeOnBackdropClick: true,
      context: {deletingObject: board},
    });
    dialogUpdatingBoard.onClose.subscribe(result => {
      if(result == true) {
        this.boardService.deleteBoard(board).subscribe(k=> {
          this.getAllBoards();
        });
      }
    });
  }


  //   deleteBoard(board: Board){
  //     this.boardService.deleteBoard(board).subscribe(k=> {
  //       this.getAllBoards(this.userId);
  //   });
  // }

  onItemClick(){
    this.menuService.onItemClick().subscribe((data) => {
      if (data.item.link === undefined) {
        const item = data.item as any;
        item.click();
      }
    });
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

  drop(event: CdkDragDrop<Board[]>) {
    if (event.previousContainer === event.container) {
      if (event.previousIndex != event.currentIndex){
        //moveItemInArray(event.previousContainer.data, event.previousIndex, event.currentIndex);
        this.boardService.changeBoardPosition(event.previousContainer.data[event.previousIndex], event.currentIndex).subscribe((response: Board[]) => {
          this.boards = response;
          moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        })
      }
    }
        // else {
        //   transferArrayItem(

        //     event.previousContainer.data,
        //     event.container.data,
        //     event.previousIndex,
        //     event.currentIndex,
        //   );
          //this.updateBoardPosition(event.container.data, event.currentIndex)

        //}
  };


}
