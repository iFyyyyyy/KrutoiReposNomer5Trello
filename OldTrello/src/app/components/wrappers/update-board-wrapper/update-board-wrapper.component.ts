import { Board } from './../../../Entities/Board';
import { Component, Inject, OnInit, Input, AfterViewInit } from '@angular/core';
import { NB_DIALOG_CONFIG, NbDialogRef, NbDialogService } from '@nebular/theme';

import { HomePageComponent } from '../../home-page/home-page.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-board-wrapper',
  templateUrl: './update-board-wrapper.component.html',
  styleUrls: ['./update-board-wrapper.component.scss']
})

export class UpdateBoardWrapperComponent implements OnInit {

  @Input()updatingBoard!: Board;



  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
      console.log(this.updatingBoard)
    }

  onClickChange(){
    this.updatingBoard.isPrivate = !this.updatingBoard.isPrivate;
    console.log(this.updatingBoard.isPrivate);
  }

   onFormSubmit(){
    this.dialogRef.close(this.updatingBoard);
   }

    ngOnInit(): void {
      console.log(this.updatingBoard)
    }

    onFormCancel(){
      this.dialogRef.close();
     }


    onNoClick(): void {
      this.dialogRef.close;
    }
}
