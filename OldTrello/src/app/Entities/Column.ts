import { Card } from "./Card";

 export class Column{

  id: number | null;
  name: string;
  boardId: number;
  position: number;
  cards: Card[];

  constructor(){
    this.id = null;
    this.name = "";
    this.boardId = 0;
    this.position = 0;
    this.cards = [];

  }



}
