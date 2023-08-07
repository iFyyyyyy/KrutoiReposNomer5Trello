import { TestBed } from '@angular/core/testing';

import { PositionChangeService } from './position-change.service';

describe('PositionChangeService', () => {
  let service: PositionChangeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PositionChangeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
