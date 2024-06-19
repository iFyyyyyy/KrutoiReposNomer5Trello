import { BoardServiceService } from 'src/app/service/board-service.service';
import { Column } from '../../Entities/Column';
import { Task} from '../../Entities/Task';
import { Component } from '@angular/core';
import { NbCardComponent, NbDialogService, NbMenuItem } from '@nebular/theme';
import {
  CdkDragDrop,
  CdkDragPlaceholder,
  CdkDrag,
  CdkDropList,
  CdkDropListGroup,
  moveItemInArray,
  transferArrayItem,
} from '@angular/cdk/drag-drop';
import { ActivatedRoute } from '@angular/router';
import { ColumnServiceService } from 'src/app/service/column-service.service';
import { TaskServiceService } from 'src/app/service/task-service.service';
import { Board } from 'src/app/Entities/Board';
import { CreateColumnWrapperComponent } from '../wrappers/column-wrappers/create-column-wrapper/create-column-wrapper.component';
import { UpdateColumnWrapperComponent } from '../wrappers/column-wrappers/update-column-wrapper/update-column-wrapper.component';
import { DeleteColumnWrapperComponent } from '../wrappers/column-wrappers/delete-column-wrapper/delete-column-wrapper.component';
import { CreateTaskWrapperComponent } from '../wrappers/task-wrappers/create-task-wrapper/create-task-wrapper.component';
import { UpdateTaskWrapperComponent } from '../wrappers/task-wrappers/update-task-wrapper/update-task-wrapper.component';
import { DeleteTaskWrapperComponent } from '../wrappers/task-wrappers/delete-task-wrapper/delete-task-wrapper.component';

@Component({
  selector: 'app-board-page',
  templateUrl: './board-page.component.html',
  styleUrls: ['./board-page.component.scss']

})
export class BoardPageComponent {

  id: number = 0;
  private sub: any;
  selectedItem = '';
  columns: Column[];
  tasks: Task[];
  board: Board;

  constructor(
    private route: ActivatedRoute,
    private columnService: ColumnServiceService,
    private taskService: TaskServiceService,
    private boardService: BoardServiceService,
    public dialog: NbDialogService,
    ){
    this.columns = [];
    this.tasks = [];
    this.board = new Board();
    }

  applyFilter(event: Event){};
  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.board.boardName.filter = filterValue.trim().toLowerCase();
  //   }
  // }

  tasksToColumns(arr: Task[], id: number) {
    let result = [];
    for (var i=0, iLen=arr.length; i<iLen; i++) {
      if (arr[i].columnId == id)
      result.push(arr[i]);
    }
    return result;
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
       this.id = +params['id']; // (+) converts string 'id' to a number
       this.getColumnsByBoardId(this.id);
       this.getBoardById(this.id);
       //this.getTasksByBoardId(this.id);
    });
  }

  getBoardById(id: number){
    this.boardService.getBoardById(id).subscribe((board: Board) => {
      this.board = board;
    })

  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  getColumnsByBoardId(id: number){
    this.columnService.getColumnsByBoardId(id).subscribe((columns: Column[]) => {

      console.log(columns);
      //this.columns = columns;
      this.columns = columns;

  })
  }


  addNewColumn() {
    const dialogAddingNewBoard = this.dialog.open(CreateColumnWrapperComponent, {
      closeOnBackdropClick: true,
      context: {data: null},
    });
    dialogAddingNewBoard.onClose.subscribe(column => {
      if(column != null) {
        this.columnService.addNewColumn(column, this.board.id).subscribe(k=> {
          this.getColumnsByBoardId(this.board.id);
        });
      }
    });
  }

  updateColumn(column: Column) {
    const dialogUpdatingBoard = this.dialog.open(UpdateColumnWrapperComponent, {
      closeOnBackdropClick: true,
      context: {updatingColumn: column},
    });
    dialogUpdatingBoard.onClose.subscribe(column => {
      if (column != null){
        this.columnService.updateColumn(column).subscribe(k=> {
          this.getColumnsByBoardId(this.board.id);
        });
      }
    });
  }

  deleteColumn(column: Column) {
    const dialogDeletingBoard = this.dialog.open(DeleteColumnWrapperComponent, {
      closeOnBackdropClick: true,
      context: {deletingColumn: column},
    });
    dialogDeletingBoard.onClose.subscribe(result => {
      if(result == true) {
        this.columnService.deleteColumn(column).subscribe(k=> {
          this.getColumnsByBoardId(this.board.id);
        });
      }
    });
  }

  addNewTask(columnId: number) {
    const dialogAddingNewBoard = this.dialog.open(CreateTaskWrapperComponent, {
      closeOnBackdropClick: true,
      context: {data: null},
    });
    dialogAddingNewBoard.onClose.subscribe((task: Task) => {
      if(task != null) {
        this.taskService.addNewTask(task, columnId).subscribe(k=> {
          this.getColumnsByBoardId(this.board.id);
        });
      }
    });
  }

  updateTask(task: Task) {
    const dialogUpdatingBoard = this.dialog.open(UpdateTaskWrapperComponent, {
      closeOnBackdropClick: true,
      context: {updatingTask: task},
    });
    dialogUpdatingBoard.onClose.subscribe(task => {
      if (task != null){
        this.taskService.updateTask(task).subscribe(k=> {
          this.getColumnsByBoardId(this.board.id);
        });
      }
    });
  }

  deleteTask(task: Task) {
    const dialogUpdatingBoard = this.dialog.open(DeleteTaskWrapperComponent, {
      closeOnBackdropClick: true,
      context: {deletingTask: task},
    });
    dialogUpdatingBoard.onClose.subscribe(result => {
      if (result != null){
        this.taskService.deleteTask(task).subscribe(k=> {
          this.getColumnsByBoardId(this.board.id);
        });
      }
    });
  }

  dropColumn(event: CdkDragDrop<Column[]>) {
    if (event.previousContainer === event.container) {
      if (event.previousIndex != event.currentIndex){
        //moveItemInArray(event.previousContainer.data, event.previousIndex, event.currentIndex);
        this.columnService.changeColumnPosition(event.previousContainer.data[event.previousIndex], event.currentIndex, this.board.id).subscribe((response: Column[]) => {
          this.columns = response;
          moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        })
      }
    }
  };

  dropTask(event: CdkDragDrop<Task[]>, currentColumnId: number) {

      if (event.previousIndex != event.currentIndex || event.container != event.previousContainer){
          this.taskService.changeTaskPositionAndColumn(
            event.previousContainer.data[event.previousIndex],
            event.currentIndex,
            currentColumnId,
            ).subscribe((response: Column[]) => {
              this.columns = response;
          //moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        })
      }
  };

  onMouseEnter(card: NbCardComponent) {
    card.accent = "info"; //= "20px" ;
    //card.status = "success";
  }

  onMouseOut(card: NbCardComponent) {
    card.accent = "basic";
    //card.status = "basic";
  }

}
