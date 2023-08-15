import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateColumnWrapperComponent } from './update-column-wrapper.component';

describe('UpdateColumnWrapperComponent', () => {
  let component: UpdateColumnWrapperComponent;
  let fixture: ComponentFixture<UpdateColumnWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateColumnWrapperComponent]
    });
    fixture = TestBed.createComponent(UpdateColumnWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
