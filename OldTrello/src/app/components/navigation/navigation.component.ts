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

  boards: Board[] | null;
  userId: number | null;

  isLight = true;
  isLoggedIn = false;

  constructor(
    private boardService: BoardServiceService,
    private themeService: NbThemeService,
    private themeCheck: ThemeServiceService,
    ){
    this.boards = [];
    this.themeService.currentTheme;
    this.userId = this.getUserId();
  };


  items: NbMenuItem[] = [
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
    },
  ];


  ngOnInit(){
    this.getAllBoards(this.userId);
    this.checkTheme();
  }

  ngDoCheck(){
    if(localStorage.getItem('isLoggedIn')){
      this.isLoggedIn = true;
    }
    else this.isLoggedIn = false;

  }

  getAllBoards(id: number | null){
    if(id != null){
      this.boardService.getAllBoards(id).subscribe( (boards: Board[]) => {
        this.boardsToNavbar(boards);
      });
    }
  }

  boardsToNavbar(boards: Board[]){


      boards.forEach((board: Board) => {

        this.items[2].children?.push({
          title: `${board.boardName}`,
          link:`board/${board.id}`,
          icon: 'arrow-right-outline'
        });
      });


  }

  onClickTheme(){
      if (!this.isLight){
        this.themeCheck.changeTheme(this.userId, "LIGHT").subscribe(k => {
          this.themeService.changeTheme('default');
        });
        this.isLight = !this.isLight;
      }
      else {
        this.themeCheck.changeTheme(this.userId, "DARK").subscribe(k => {
          this.themeService.changeTheme('dark');
        });
        this.isLight = !this.isLight;
      }

  }

  checkTheme(){
    if(this.userId != null){
      this.themeCheck.getTheme(this.userId).subscribe((result: String) => {
        if(result = "LIGHT"){
          this.themeService.changeTheme('default');
        }
        else this.themeService.changeTheme('dark');
      })
    };
  }

  getUserId(){
    return Number(localStorage.getItem("UserId"));
  }

  onMouseEnter(sidebar: NbSidebarComponent) {
    sidebar.expand();

  }

  onMouseOut(sidebar: NbSidebarComponent) {
    sidebar.compact();
    this.expanded = false;

}

}
