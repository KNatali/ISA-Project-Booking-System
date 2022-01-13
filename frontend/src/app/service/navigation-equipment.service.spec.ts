import { TestBed } from '@angular/core/testing';

import { NavigationEquipmentService } from './navigation-equipment.service';

describe('NavigationEquipmentService', () => {
  let service: NavigationEquipmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NavigationEquipmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
