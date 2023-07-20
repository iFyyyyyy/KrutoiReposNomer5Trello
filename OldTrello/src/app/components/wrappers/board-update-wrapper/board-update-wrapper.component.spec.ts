import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardUpdateWrapperComponent } from './board-update-wrapper.component';

describe('BoardUpdateWrapperComponent', () => {
  let component: BoardUpdateWrapperComponent;
  let fixture: ComponentFixture<BoardUpdateWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BoardUpdateWrapperComponent]
    });
    fixture = TestBed.createComponent(BoardUpdateWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
