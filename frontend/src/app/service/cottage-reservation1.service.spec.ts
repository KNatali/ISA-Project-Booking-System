import { TestBed } from '@angular/core/testing';

import { CottageReservation1Service } from './cottage-reservation1.service';

describe('CottageReservation1Service', () => {
  let service: CottageReservation1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CottageReservation1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
