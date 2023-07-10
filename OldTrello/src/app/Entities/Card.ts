 export class Card{

  id: number | null;
  name: string;
  description: string;
  columnId: number | null;
  lastUpdated: Date;


  constructor(){
    this.id = null;
    this.name = "";
    this.description = "";
    this.columnId =  null;
    this.lastUpdated = new Date();


  }



}
