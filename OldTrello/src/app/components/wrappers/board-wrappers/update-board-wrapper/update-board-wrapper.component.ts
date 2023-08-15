import { Board } from 'src/app/Entities/Board';
import { Component, Inject, OnInit, Input, AfterViewInit } from '@angular/core';
import { NB_DIALOG_CONFIG, NbDialogRef, NbDialogService } from '@nebular/theme';

import { HomePageComponent } from '../../../home-page/home-page.component';
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
      this.updatingBoardWrapper = new Board();
    }


  // Полная хуйня, зато работает
  boardToBoardWrapper(): void{
      this.updatingBoardWrapper.boardName = this.updatingBoard.boardName;
      this.updatingBoardWrapper.boardDescription = this.updatingBoard.boardDescription;
      this.updatingBoardWrapper.boardPosition = this.updatingBoard.boardPosition;
      this.updatingBoardWrapper.id = this.updatingBoard.id;
      this.updatingBoardWrapper.isPrivate = this.updatingBoardWrapper.isPrivate;
    }

  onClickChange(){
    this.updatingBoardWrapper.isPrivate = !this.updatingBoardWrapper.isPrivate;
    //console.log(this.updatingBoardWrapper.isPrivate);
  }

   onFormSubmit(){
    this.dialogRef.close(this.updatingBoardWrapper);
   }

    ngOnInit() {
      this.boardToBoardWrapper();
    }

    onFormCancel(){
      this.dialogRef.close();
     }


    onNoClick(): void {
      this.dialogRef.close;
    }
}
