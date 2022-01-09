import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerReservationReportComponent } from './cottage-owner-reservation-report.component';

describe('CottageOwnerReservationReportComponent', () => {
  let component: CottageOwnerReservationReportComponent;
  let fixture: ComponentFixture<CottageOwnerReservationReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerReservationReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerReservationReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
