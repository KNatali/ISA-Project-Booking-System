import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerUpcomingReservationsComponent } from './boat-owner-upcoming-reservations.component';

describe('BoatOwnerUpcomingReservationsComponent', () => {
  let component: BoatOwnerUpcomingReservationsComponent;
  let fixture: ComponentFixture<BoatOwnerUpcomingReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerUpcomingReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerUpcomingReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
