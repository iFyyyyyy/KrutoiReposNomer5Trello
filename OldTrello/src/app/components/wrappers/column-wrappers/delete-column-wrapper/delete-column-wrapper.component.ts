import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Column } from 'src/app/Entities/Column';
import { HomePageComponent } from 'src/app/components/home-page/home-page.component';

@Component({
  selector: 'app-delete-column-wrapper',
  templateUrl: './delete-column-wrapper.component.html',
  styleUrls: ['./delete-column-wrapper.component.scss']
})
export class DeleteColumnWrapperComponent {

  dialogHeader: string = ``;
  @Input()deletingColumn!: Column;

  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
  }

  ngOnInit(): void {
    console.log(this.deletingColumn);
    this.dialogHeaderImpl();
  }

  dialogHeaderImpl(){
    this.dialogHeader = `Delete ${this.deletingColumn.columnName}?`
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
