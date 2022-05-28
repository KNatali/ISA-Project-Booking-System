import { TestBed } from '@angular/core/testing';

import { ComplaintCottageReservationService } from './complaint-cottage-reservation.service';

describe('ComplaintCottageReservationService', () => {
  let service: ComplaintCottageReservationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComplaintCottageReservationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
