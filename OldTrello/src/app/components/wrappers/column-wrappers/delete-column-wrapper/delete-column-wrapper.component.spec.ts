import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteColumnWrapperComponent } from './delete-column-wrapper.component';

describe('DeleteColumnWrapperComponent', () => {
  let component: DeleteColumnWrapperComponent;
  let fixture: ComponentFixture<DeleteColumnWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeleteColumnWrapperComponent]
    });
    fixture = TestBed.createComponent(DeleteColumnWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
