import { Task } from "./Task";

 export class Column{

  id: number;
  columnName: string;
  boardId: number;
  position: number;
  cards: Task[];

  constructor(){
    this.id = 0;
    this.columnName = "";
    this.boardId = 0;
    this.position = 0;
    this.cards = [];

  }



}
