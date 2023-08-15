import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBoardWrapperComponent } from './update-board-wrapper.component';

describe('UpdateBoardWrapperComponent', () => {
  let component: UpdateBoardWrapperComponent;
  let fixture: ComponentFixture<UpdateBoardWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateBoardWrapperComponent]
    });
    fixture = TestBed.createComponent(UpdateBoardWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
