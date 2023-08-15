import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTaskWrapperComponent } from './create-task-wrapper.component';

describe('CreateTaskWrapperComponent', () => {
  let component: CreateTaskWrapperComponent;
  let fixture: ComponentFixture<CreateTaskWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateTaskWrapperComponent]
    });
    fixture = TestBed.createComponent(CreateTaskWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
