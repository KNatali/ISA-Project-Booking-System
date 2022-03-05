import { TestBed } from '@angular/core/testing';

import { AdventureRevisionService } from './adventure-revision.service';

describe('AdventureRevisionService', () => {
  let service: AdventureRevisionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdventureRevisionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
