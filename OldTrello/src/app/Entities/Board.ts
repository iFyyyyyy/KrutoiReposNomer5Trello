 export class Board{

  id: number;
  boardName: string;
  boardDescription: string;
  user: string;
  isPrivate: boolean;


  constructor(){
    this.id = 0;
    this.boardName = "";
    this.boardDescription = "";
    this.user = "userOwner";
    this.isPrivate = false;

  }



}
