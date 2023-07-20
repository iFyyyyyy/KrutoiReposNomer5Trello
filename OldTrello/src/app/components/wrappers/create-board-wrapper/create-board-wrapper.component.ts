import { Component, Inject } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Board } from 'src/app/Entities/Board';

@Component({
  selector: 'app-create-board-wrapper',
  templateUrl: './create-board-wrapper.component.html',
  styleUrls: ['./create-board-wrapper.component.scss']
})
export class CreateBoardWrapperComponent {
  newBoard: Board;

  constructor( public dialogRef: NbDialogRef<any>,
    @Inject(Object) public data: any
      )    {
      this.newBoard = new Board;
    }

    ngOnInit(): void {
    }

    onNoClick(): void {
      this.dialogRef.close;
    }
}
