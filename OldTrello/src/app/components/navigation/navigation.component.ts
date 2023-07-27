import { BoardServiceService } from 'src/app/service/board-service.service';
import { Component } from '@angular/core';
import { NbMenuItem, NbMenuService, NbSidebarComponent, NbThemeService } from '@nebular/theme';
import { Board } from 'src/app/Entities/Board';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent {
  expanded: boolean = false;

  boards: Board[] | null;
  id: number = 1;

  isLight = true;

  constructor(private boardService: BoardServiceService, private themeService: NbThemeService){
    this.boards = [];
    this.themeService.currentTheme;
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
    this.getAllBoards(this.id);

  }

  ngDoCheck(){

  }

  getAllBoards(id: number){
    this.boardService.getAllBoards(id).subscribe( (boards: Board[]) => {

      this.boardsToNavbar(boards);
    });

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
    this.isLight = !this.isLight;
    if (this.themeService.currentTheme == 'dark'){
      this.themeService.changeTheme('default');
    }
    else this.themeService.changeTheme('dark');
  }


  onMouseEnter(sidebar: NbSidebarComponent) {
    sidebar.expand();

  }

  onMouseOut(sidebar: NbSidebarComponent) {
    sidebar.compact();
    this.expanded = false;

}

}
