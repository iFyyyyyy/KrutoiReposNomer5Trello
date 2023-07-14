
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



@Component({
  selector: 'app-board-page',
  templateUrl: './board-page.component.html',
  styleUrls: ['./board-page.component.scss']

})
export class BoardPageComponent {

  id: number = 0;
  private sub: any;

  // todo = ['Get to work', 'Pick up groceries', 'Go home', 'Fall asleep', 'SUCK VERY BIG PENIS'];
  // done = ['Get up', 'Brush teeth', 'Take a shower', 'Check e-mail', 'Walk dog'];
  columns: Column[];
  tasks: Task[];

  constructor(private route: ActivatedRoute, private columnService: ColumnServiceService,
    private taskService: TaskServiceService){
    this.columns = [];
    this.tasks = [];

  }

  cardOptions: NbMenuItem[] = [
    {
      title: 'Home',
      icon: 'home-outline',
      link: 'home',
    },
  ];

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
       //this.getTasksByBoardId(this.id);



       // In a real app: dispatch action to load the details here.

    });
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
