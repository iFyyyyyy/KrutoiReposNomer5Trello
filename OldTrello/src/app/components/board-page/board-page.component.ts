
import { Column } from './../../Entities/Column';
import { Card } from './../../Entities/Card';
import { Component } from '@angular/core';
import { NbCardComponent, NbMenuItem } from '@nebular/theme';
import {
  CdkDragDrop,
  CdkDrag,
  CdkDropList,
  CdkDropListGroup,
  moveItemInArray,
  transferArrayItem,
} from '@angular/cdk/drag-drop';



@Component({
  selector: 'app-board-page',
  templateUrl: './board-page.component.html',
  styleUrls: ['./board-page.component.scss']

})
export class BoardPageComponent {

  // todo = ['Get to work', 'Pick up groceries', 'Go home', 'Fall asleep', 'SUCK VERY BIG PENIS'];
  // done = ['Get up', 'Brush teeth', 'Take a shower', 'Check e-mail', 'Walk dog'];
  columns: Column[];
  cards: Card[];

  constructor(){
    this.cards = [
      {id: 0, name: "Card1", description: "DescCard1 ToDo", columnId: 0, lastUpdated: new Date() },
      {id: 1, name: "Card2", description: "DescCard1 ToDo", columnId: 0, lastUpdated: new Date() },
      {id: 2, name: "Card3", description: "DescCard2 InProgress", columnId: 1, lastUpdated: new Date() },
      {id: 3, name: "Card4", description: "DescCard3 Completed" , columnId: 2, lastUpdated: new Date() },
    ]

    this.columns = [
      {id: 0, name: "ToDo", boardId: 0, position: 0, cards: this.getCards(this.cards, 0)},
      {id: 1, name: "InProgress", boardId: 0, position: 1, cards: this.getCards(this.cards, 1)},
      {id: 2, name: "Completed", boardId: 0, position: 2, cards: this.getCards(this.cards, 2)},
      {id: 3, name: "ColumnName4", boardId: 0, position: 3, cards: this.getCards(this.cards, 3)},

    ];
  }

  cardOptions: NbMenuItem[] = [
    {
      title: 'Home',
      icon: 'home-outline',
      link: 'home',
    },
  ];


  getCards(arr: Card[], id: number) {

    let result = [];

    for (var i=0, iLen=arr.length; i<iLen; i++) {

      if (arr[i].columnId == id)
      result.push(arr[i]);

    }
    return result;
  }






  drop(event: CdkDragDrop<any[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
    }


  }







  onMouseEnter(card: NbCardComponent) {
    card.accent = "info"; //= "20px" ;
    //card.status = "success";
  }

  onMouseOut(card: NbCardComponent) {
    card.accent = "basic";
    //card.status = "basic";
}

}
