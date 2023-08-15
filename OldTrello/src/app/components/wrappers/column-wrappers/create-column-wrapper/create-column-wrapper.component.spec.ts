import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateColumnWrapperComponent } from './create-column-wrapper.component';

describe('CreateColumnWrapperComponent', () => {
  let component: CreateColumnWrapperComponent;
  let fixture: ComponentFixture<CreateColumnWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateColumnWrapperComponent]
    });
    fixture = TestBed.createComponent(CreateColumnWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
