import { TestBed } from '@angular/core/testing';

import { AdditionalItemService } from './additional-item.service';

describe('AdditionalItemService', () => {
  let service: AdditionalItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdditionalItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
