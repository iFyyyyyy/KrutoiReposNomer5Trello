import { TestBed } from '@angular/core/testing';

import { ColumnServiceService } from './column-service.service';

describe('ColumnServiceService', () => {
  let service: ColumnServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ColumnServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
