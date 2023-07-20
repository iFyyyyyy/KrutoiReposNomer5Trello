import { style } from '@angular/animations';
import { AppRoutingModule } from './../../app-routing.module';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
import { CreateBoardWrapperComponent } from '../wrappers/create-board-wrapper/create-board-wrapper.component';
import { BoardUpdateWrapperComponent } from '../wrappers/board-update-wrapper/board-update-wrapper.component';
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
      this.getAllBoards(this.userId);
    }


    getAllBoards(userId: number){
      this.boardService.getAllBoards(userId).subscribe((boards: Board[]) => {
        console.log(boards);
        this.boards = boards;
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
      const dialogAddingNewBoard = this.dialog.open(BoardUpdateWrapperComponent, {
        closeOnBackdropClick: true,
        context: {data: null},
      });
      dialogAddingNewBoard.onClose.subscribe(board => {
        if(board != null) {
          console.log("adding new board: " + board.boardName);
          this.boardService.addNewBoard(board, this.userId).subscribe(k=>
            this.getAllBoards(this.userId));
        }
      });
    }

    // updateStudent(student: Student) {
    //   console.log("updating student " + student);
    //   const dialogUpdatingStudent = this.dialog.open(DialogUpdateWrapperComponent, {
    //     width: '400px',
    //     data: student
    //   });
    //   dialogUpdatingStudent.afterClosed().subscribe((result: Student) => {
    //     if(result != null) {
    //       console.log("updating student" + result);
    //       this.baseService.updateStudent(result).subscribe(k=>
    //         this.baseService.getStudents(this.pageIndex, this.pageSize).subscribe(data =>  {this.dataSource.data = data;
    //         }));
    //     }
    //   });
    // }

    // deleteStudent(student: Student){
    //   console.log("Deleting student " + student);
    //   this.baseService.deleteStudent(student).subscribe(k =>
    //     this.baseService.getStudents(this.pageIndex, this.pageSize).subscribe(data => {this.dataSource.data = data;
    //     }))
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
