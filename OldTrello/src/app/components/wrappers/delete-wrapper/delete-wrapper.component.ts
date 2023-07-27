import { Component, Input, OnInit } from '@angular/core';
import { HomePageComponent } from '../../home-page/home-page.component';
import { NbDialogRef } from '@nebular/theme';
import { Board } from 'src/app/Entities/Board';
import { Column } from 'src/app/Entities/Column';
import { Task } from 'src/app/Entities/Task';

@Component({
  selector: 'app-delete-wrapper',
  templateUrl: './delete-wrapper.component.html',
  styleUrls: ['./delete-wrapper.component.css']
})
export class DeleteWrapperComponent implements OnInit {

  dialogHeader: string = ``;
  @Input()deletingObject!: Board;



  constructor(private dialogRef: NbDialogRef<HomePageComponent>){

  }

  ngOnInit(): void {
    console.log(this.deletingObject);
    this.dialogHeaderImpl();
  }

  dialogHeaderImpl(){
    this.dialogHeader = `Delete ${this.deletingObject.boardName}?`
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
