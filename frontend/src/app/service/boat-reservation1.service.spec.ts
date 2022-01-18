import { TestBed } from '@angular/core/testing';

import { BoatReservation1Service } from './boat-reservation1.service';

describe('BoatReservation1Service', () => {
  let service: BoatReservation1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoatReservation1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
