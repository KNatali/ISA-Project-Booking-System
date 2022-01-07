import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminComplaintAnswerComponent } from './admin-complaint-answer.component';

describe('AdminComplaintAnswerComponent', () => {
  let component: AdminComplaintAnswerComponent;
  let fixture: ComponentFixture<AdminComplaintAnswerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminComplaintAnswerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminComplaintAnswerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
