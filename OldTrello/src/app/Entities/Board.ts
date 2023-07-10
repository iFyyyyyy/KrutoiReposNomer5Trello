 export class Board{

  id: number | null = 0;
  name: string = "";
  description: string = "";
  user: string = "";
  privacy: string = "" ;


  constructor(){
    this.id = null;
    this.name = "";
    this.description = "";
    this.user = "userOwner";
    this.privacy = "public";

  }



}
