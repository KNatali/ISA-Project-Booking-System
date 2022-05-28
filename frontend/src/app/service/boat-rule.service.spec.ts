import { TestBed } from '@angular/core/testing';

import { BoatRuleService } from './boat-rule.service';

describe('BoatRuleService', () => {
  let service: BoatRuleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoatRuleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
