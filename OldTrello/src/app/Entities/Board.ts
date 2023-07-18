 export class Board{

  id: number;
  boardName: string;
  boardDescription: string;
  boardPosition: number;
  isPrivate: boolean;


  constructor(){
    this.id = 0;
    this.boardName = "";
    this.boardDescription = "";
    this.boardPosition = 0;
    this.isPrivate = false;

  }



}
