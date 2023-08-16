import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Task } from 'src/app/Entities/Task';
import { HomePageComponent } from 'src/app/components/home-page/home-page.component';

@Component({
  selector: 'app-update-task-wrapper',
  templateUrl: './update-task-wrapper.component.html',
  styleUrls: ['./update-task-wrapper.component.scss']
})
export class UpdateTaskWrapperComponent {

  @Input()updatingTask!: Task;
  updatingTaskWrapper: Task;

  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
    this.updatingTaskWrapper = new Task();
  }

  taskToTaskWrapper(): void{
    this.updatingTaskWrapper.id = this.updatingTask.id;
    this.updatingTaskWrapper.columnId = this.updatingTask.columnId;
    this.updatingTaskWrapper.taskName = this.updatingTask.taskName;
    this.updatingTaskWrapper.taskDescription = this.updatingTask.taskDescription;
  }

  onFormSubmit(){
    this.updatingTaskWrapper.lastUpdated = new Date();
    this.dialogRef.close(this.updatingTaskWrapper);
  }

  ngOnInit() {
      this.taskToTaskWrapper();
  }

  onFormCancel(){
      this.dialogRef.close();
  }


  onNoClick(): void {
    this.dialogRef.close;
  }


}
