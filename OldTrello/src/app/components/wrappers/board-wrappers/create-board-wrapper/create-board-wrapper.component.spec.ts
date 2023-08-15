import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBoardWrapperComponent } from './create-board-wrapper.component';

describe('CreateBoardWrapperComponent', () => {
  let component: CreateBoardWrapperComponent;
  let fixture: ComponentFixture<CreateBoardWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateBoardWrapperComponent]
    });
    fixture = TestBed.createComponent(CreateBoardWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
