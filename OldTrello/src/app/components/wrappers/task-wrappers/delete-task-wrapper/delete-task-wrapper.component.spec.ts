import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteTaskWrapperComponent } from './delete-task-wrapper.component';

describe('DeleteTaskWrapperComponent', () => {
  let component: DeleteTaskWrapperComponent;
  let fixture: ComponentFixture<DeleteTaskWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeleteTaskWrapperComponent]
    });
    fixture = TestBed.createComponent(DeleteTaskWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
