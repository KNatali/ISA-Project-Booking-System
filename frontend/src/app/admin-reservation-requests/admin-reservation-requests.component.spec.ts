import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminReservationRequestsComponent } from './admin-reservation-requests.component';

describe('AdminReservationRequestsComponent', () => {
  let component: AdminReservationRequestsComponent;
  let fixture: ComponentFixture<AdminReservationRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminReservationRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminReservationRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
