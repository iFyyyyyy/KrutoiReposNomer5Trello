import { ThemeServiceService } from './../../service/theme-service.service';
import { BoardServiceService } from 'src/app/service/board-service.service';
import { Component } from '@angular/core';
import { NbMenuItem, NbMenuService, NbSidebarComponent, NbThemeService } from '@nebular/theme';
import { Board } from 'src/app/Entities/Board';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent {
  expanded: boolean = false;

  username: string | null = "";

  boards: Board[] | null;
  userId: number | null = null;

  isLight = true;
  isLoggedIn = false;

  constructor(
    private boardService: BoardServiceService,
    private themeService: NbThemeService,
    private themeCheck: ThemeServiceService,
    ){
    this.boards = [];
    this.themeService.currentTheme;

  };


  sidebarItems: NbMenuItem[] = [
    {
      title: 'Home',
      icon: 'home-outline',
      link: 'home',
    },
    {
      title: 'Profile',
      icon: 'person-outline',
    },
    {
      title: 'My Boards',
      expanded: this.expanded,
      icon: 'clipboard-outline',

      children: [
        //   {
        //   title: 'Board1',
        //   badge: {
        //     text: '99+',
        //     status: 'danger',
        //   },
        // },
      ],
    },
    {
      title: 'Logout',
      icon: 'log-out-outline',
      link: 'logout',

    },
  ];

  getUsername(){
    this.username =  localStorage.getItem('Username');
  }




  ngOnInit(){
    this.checkLoggedIn();
    this.getAllBoards();
    //this.checkTheme();
    this.getTheme();
    this.getUsername();
    this.getUserId();
  }

  checkLoggedIn(){
    if(localStorage.getItem('isLoggedIn')){
    return this.isLoggedIn = true;
    }
    else
    return this.isLoggedIn = false;
  }


  // el hueta
  ngDoCheck(){
    if(localStorage.getItem('isLoggedIn')){
      this.isLoggedIn = true;
    }
    else {
      this.isLoggedIn = false;
    }
  }

  getAllBoards(){
      this.boardService.getAllBoards().subscribe( (boards: Board[]) => {
        this.boardsToNavbar(boards);
      });

  }

  boardsToNavbar(boards: Board[]){
      boards.forEach((board: Board) => {

        this.sidebarItems[2].children?.push({
          title: `${board.boardName}`,
          link:`board/${board.id}`,
          icon: 'arrow-right-outline'
        });
      });
  }

  onClickTheme(){
    this.isLight = !this.isLight;
    this.themeCheck.changeTheme().subscribe((theme: string) => {
      this.getTheme();
    });
  }

  getTheme(){
    this.themeCheck.getTheme().subscribe((theme: string) =>{
      //debugger
      if (theme == "LIGHT"){
        this.isLight = true;
        this.themeService.changeTheme('default');
      }
      else {
        this.isLight = false;
        this.themeService.changeTheme('dark');
      }
    })
  }


  getUserId(){
    this.userId =  Number(localStorage.getItem("UserId"));
  }

  onMouseEnter(sidebar: NbSidebarComponent) {
    sidebar.expand();

  }

  onMouseOut(sidebar: NbSidebarComponent) {
    sidebar.compact();
    this.expanded = false;
  }

}
