import { TestBed } from '@angular/core/testing';

import { Cottage1Service } from './cottage1.service';

describe('Cottage1Service', () => {
  let service: Cottage1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cottage1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
