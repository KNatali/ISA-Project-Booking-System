import { TestBed } from '@angular/core/testing';

import { CottageRuleService } from './cottage-rule.service';

describe('CottageRuleService', () => {
  let service: CottageRuleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CottageRuleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
