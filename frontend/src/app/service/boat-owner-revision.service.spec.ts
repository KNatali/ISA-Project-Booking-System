import { TestBed } from '@angular/core/testing';

import { BoatOwnerRevisionService } from './boat-owner-revision.service';

describe('BoatOwnerRevisionService', () => {
  let service: BoatOwnerRevisionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoatOwnerRevisionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
