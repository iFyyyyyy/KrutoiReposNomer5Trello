import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Task } from 'src/app/Entities/Task';
import { HomePageComponent } from 'src/app/components/home-page/home-page.component';

@Component({
  selector: 'app-create-task-wrapper',
  templateUrl: './create-task-wrapper.component.html',
  styleUrls: ['./create-task-wrapper.component.scss']
})
export class CreateTaskWrapperComponent {

  newTask: Task;
  @Input()public data!: null;

  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
      this.newTask = new Task();
    }

  // onClickChange(){
  //   this.newBoard.isPrivate = !this.newBoard.isPrivate;
  // }

   onFormSubmit(){
    this.dialogRef.close(this.newTask);
   }

   onFormCancel(){
    this.dialogRef.close();
   }

    ngOnInit(): void {
    }

    onNoClick(): void {
      this.dialogRef.close;
    }
}
