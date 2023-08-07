import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestdragdropComponent } from './testdragdrop.component';

describe('TestdragdropComponent', () => {
  let component: TestdragdropComponent;
  let fixture: ComponentFixture<TestdragdropComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TestdragdropComponent]
    });
    fixture = TestBed.createComponent(TestdragdropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
