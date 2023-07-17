import { BoardServiceService } from 'src/app/service/board-service.service';

import { Column } from '../../Entities/Column';
import { Task} from '../../Entities/Task';
import { Component } from '@angular/core';
import { NbCardComponent, NbMenuItem } from '@nebular/theme';
import {
  CdkDragDrop,
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



@Component({
  selector: 'app-board-page',
  templateUrl: './board-page.component.html',
  styleUrls: ['./board-page.component.scss']

})
export class BoardPageComponent {

  id: number = 0;
  private sub: any;
  selectedItem = '';

  // todo = ['Get to work', 'Pick up groceries', 'Go home', 'Fall asleep', 'SUCK VERY BIG PENIS'];
  // done = ['Get up', 'Brush teeth', 'Take a shower', 'Check e-mail', 'Walk dog'];
  columns: Column[];
  tasks: Task[];
  board: Board;

  constructor(private route: ActivatedRoute, private columnService: ColumnServiceService,
    private taskService: TaskServiceService, private boardService: BoardServiceService){
    this.columns = [];
    this.tasks = [];
    this.board = new Board();

  }

  menuOptions: NbMenuItem[] = [
    {
      title: 'Create New Column',
      icon: 'plus-square-outline',
    },

  ];

  cardOptions: NbMenuItem[] = [
    {
      title: 'Home',
      icon: 'home-outline',
      link: 'home',
    },
  ];

  columnOptions: NbMenuItem[] = [
    {
      title: 'Edit Column',
      icon: 'edit-outline',
    },
    {
      title: 'Delete Column',
      icon: 'trash-2-outline',
     // link: 'home',
    },
  ];

  taskOptions: NbMenuItem[] = [
    {
      title: 'Edit Task',
      icon: 'edit-outline',
    },
    {
      title: 'Delete Task',
      icon: 'trash-2-outline',
     // link: 'home',
    },
  ];



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



       // In a real app: dispatch action to load the details here.

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


  // getTasksByBoardId(id: number){
  //   let tasks: Task[] = [];
  //   this.taskService.getTasksByBoardId(id).subscribe((tasks: Task[]) => {

  //     this.tasks = tasks;

  // })
  // }


  getTasksByBoardId(id: number){
    this.taskService.getTasksByBoardId(id).subscribe((tasks: Task[]) => {

      this.tasks = tasks;

  })

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


  }







  onMouseEnter(card: NbCardComponent) {
    card.accent = "info"; //= "20px" ;
    //card.status = "success";
  }

  onMouseOut(card: NbCardComponent) {
    card.accent = "basic";
    //card.status = "basic";
}

}
