import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminReservationReportsComponent } from './admin-reservation-reports.component';

describe('AdminReservationReportsComponent', () => {
  let component: AdminReservationReportsComponent;
  let fixture: ComponentFixture<AdminReservationReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminReservationReportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminReservationReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
