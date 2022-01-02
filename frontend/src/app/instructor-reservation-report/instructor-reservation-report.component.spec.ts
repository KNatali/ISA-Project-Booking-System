import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorReservationReportComponent } from './instructor-reservation-report.component';

describe('InstructorReservationReportComponent', () => {
  let component: InstructorReservationReportComponent;
  let fixture: ComponentFixture<InstructorReservationReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorReservationReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorReservationReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
