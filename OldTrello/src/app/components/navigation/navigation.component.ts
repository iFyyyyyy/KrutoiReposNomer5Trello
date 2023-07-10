import { Component } from '@angular/core';
import { NbMenuItem, NbMenuService, NbSidebarComponent } from '@nebular/theme';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent {
  expanded: boolean = false;


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
          {
          title: 'Board1',
          badge: {
            text: '99+',
            status: 'danger',
          },
        },
      ],
    },
    {
      title: 'Logout',
      icon: 'unlock-outline',
    },
  ];

  onMouseEnter(sidebar: NbSidebarComponent) {
    sidebar.expand();
    //this.expanded = true;

    //this.items.collapseItems


  }

  onMouseOut(sidebar: NbSidebarComponent) {
    sidebar.compact();
    this.expanded = false;

}
}
