import { TestBed } from '@angular/core/testing';

import { ComplaintBoatReservationService } from './complaint-boat-reservation.service';

describe('ComplaintBoatReservationService', () => {
  let service: ComplaintBoatReservationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComplaintBoatReservationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
