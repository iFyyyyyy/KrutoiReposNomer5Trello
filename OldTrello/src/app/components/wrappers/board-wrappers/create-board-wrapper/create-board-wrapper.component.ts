import { Component, Inject, OnInit, Input } from '@angular/core';
import { NbDialogRef, NbDialogService } from '@nebular/theme';
import { Board } from 'src/app/Entities/Board';
import { HomePageComponent } from '../../../home-page/home-page.component';

@Component({
  selector: 'app-create-board-wrapper',
  templateUrl: './create-board-wrapper.component.html',
  styleUrls: ['./create-board-wrapper.component.scss']
})
export class CreateBoardWrapperComponent implements OnInit {
  newBoard: Board;
  @Input()public data!: null;



  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
      this.newBoard = new Board();
    }

  onClickChange(){
    this.newBoard.isPrivate = !this.newBoard.isPrivate;
  }

   onFormSubmit(){
    this.dialogRef.close(this.newBoard);
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
