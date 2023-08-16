import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Column } from 'src/app/Entities/Column';
import { HomePageComponent } from 'src/app/components/home-page/home-page.component';

@Component({
  selector: 'app-create-column-wrapper',
  templateUrl: './create-column-wrapper.component.html',
  styleUrls: ['./create-column-wrapper.component.scss']
})
export class CreateColumnWrapperComponent {
  newColumn: Column;
  @Input()public data!: null;




  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
      this.newColumn = new Column();
    }

  // onClickChange(){
  //   this.newColumn.isPrivate = !this.newBoard.isPrivate;
  // }

   onFormSubmit(){
    this.dialogRef.close(this.newColumn);
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
