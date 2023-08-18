 export class User{

  id: number;
  username: string;
  password: string;
  role: string;
  isEnable: boolean;
  theme: string;


  constructor(){
    this.id = 0;
    this.username = "";
    this.password = "";
    this.role = "";
    this.isEnable = true;
    this.theme = "";
  }



}
