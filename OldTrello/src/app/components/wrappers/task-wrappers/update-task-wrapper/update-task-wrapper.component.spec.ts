import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTaskWrapperComponent } from './update-task-wrapper.component';

describe('UpdateTaskWrapperComponent', () => {
  let component: UpdateTaskWrapperComponent;
  let fixture: ComponentFixture<UpdateTaskWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateTaskWrapperComponent]
    });
    fixture = TestBed.createComponent(UpdateTaskWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
