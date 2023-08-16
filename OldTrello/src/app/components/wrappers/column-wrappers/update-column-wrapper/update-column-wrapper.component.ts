import { Component, Input } from '@angular/core';
import { NbDialogRef } from '@nebular/theme';
import { Column } from 'src/app/Entities/Column';
import { HomePageComponent } from 'src/app/components/home-page/home-page.component';

@Component({
  selector: 'app-update-column-wrapper',
  templateUrl: './update-column-wrapper.component.html',
  styleUrls: ['./update-column-wrapper.component.scss']
})
export class UpdateColumnWrapperComponent {

  @Input()updatingColumn!: Column;

  updatingColumnWrapper: Column;

  constructor(private dialogRef: NbDialogRef<HomePageComponent>){
      this.updatingColumnWrapper = new Column();
    }

  columnToColumnWrapper(): void{
    this.updatingColumnWrapper.columnName = this.updatingColumn.columnName;
    this.updatingColumnWrapper.id = this.updatingColumn.id;
    // this.updatingColumnWrapper.boardId = this.updatingColumn.boardId;
    // this.updatingColumnWrapper.position = this.updatingColumn.position;
    // this.updatingColumnWrapper.tasks = this.updatingColumn.tasks;
  }

  onFormSubmit(){
    this.dialogRef.close(this.updatingColumnWrapper);
  }

  ngOnInit() {
      this.columnToColumnWrapper();
  }

  onFormCancel(){
      this.dialogRef.close();
  }


  onNoClick(): void {
    this.dialogRef.close;
  }
}
