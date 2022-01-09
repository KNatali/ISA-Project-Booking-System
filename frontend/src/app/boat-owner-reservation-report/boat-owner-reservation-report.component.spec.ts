import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerReservationReportComponent } from './boat-owner-reservation-report.component';

describe('BoatOwnerReservationReportComponent', () => {
  let component: BoatOwnerReservationReportComponent;
  let fixture: ComponentFixture<BoatOwnerReservationReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerReservationReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerReservationReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
