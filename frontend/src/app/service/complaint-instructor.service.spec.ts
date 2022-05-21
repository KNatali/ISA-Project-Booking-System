import { TestBed } from '@angular/core/testing';

import { ComplaintInstructorService } from './complaint-instructor.service';

describe('ComplaintInstructorService', () => {
  let service: ComplaintInstructorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComplaintInstructorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
