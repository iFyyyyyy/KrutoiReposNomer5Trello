 export class Task{

  id: number | null;
  taskName: string;
  taskDescription: string;
  columnId: number | null;
  lastUpdated: Date;


  constructor(){
    this.id = null;
    this.taskName = "";
    this.taskDescription = "";
    this.columnId =  null;
    this.lastUpdated = new Date();


  }



}
