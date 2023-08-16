import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Task } from 'src/app/Entities/Task';
import { HomePageComponent } from 'src/app/components/home-page/home-page.component';

@Component({
  selector: 'app-delete-task-wrapper',
  templateUrl: './delete-task-wrapper.component.html',
  styleUrls: ['./delete-task-wrapper.component.scss']
})
export class DeleteTaskWrapperComponent {

  dialogHeader: string = ``;
  @Input()deletingTask!: Task;

  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
  }

  ngOnInit(): void {
    console.log(this.deletingTask);
    this.dialogHeaderImpl();
  }

  dialogHeaderImpl(){
    this.dialogHeader = `Delete ${this.deletingTask.taskName}?`
  }

  onFormSubmit(){
    this.dialogRef.close(true);
  }

  onFormCancel(){
      this.dialogRef.close();
  }

  onNoClick(): void {
      this.dialogRef.close;
  }
}
