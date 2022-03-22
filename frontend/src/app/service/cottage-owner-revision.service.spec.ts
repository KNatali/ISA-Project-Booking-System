import { TestBed } from '@angular/core/testing';

import { CottageOwnerRevisionService } from './cottage-owner-revision.service';

describe('CottageOwnerRevisionService', () => {
  let service: CottageOwnerRevisionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CottageOwnerRevisionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
