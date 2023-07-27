import { Board } from './../../../Entities/Board';
import { Component, Inject, OnInit, Input, AfterViewInit } from '@angular/core';
import { NB_DIALOG_CONFIG, NbDialogRef, NbDialogService } from '@nebular/theme';

import { HomePageComponent } from '../../home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { empty } from 'rxjs';

@Component({
  selector: 'app-update-board-wrapper',
  templateUrl: './update-board-wrapper.component.html',
  styleUrls: ['./update-board-wrapper.component.scss']
})

export class UpdateBoardWrapperComponent implements OnInit {

  @Input()updatingBoard!: Board;

  updatingBoardWrapper: Board;

  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
      this.updatingBoardWrapper = this.updatingBoard;
    }

  onClickChange(){
    this.updatingBoardWrapper.isPrivate = !this.updatingBoardWrapper.isPrivate;
    //console.log(this.updatingBoardWrapper.isPrivate);
  }

   onFormSubmit(){
    this.dialogRef.close(this.updatingBoardWrapper);
   }

    ngOnInit(): void {
      // this.updatingBoardWrapper = this.updatingBoard;
      // console.log(this.updatingBoardWrapper);
    }

    onFormCancel(){
      this.dialogRef.close(this.updatingBoard);
     }


    onNoClick(): void {
      this.dialogRef.close;
    }
}
