import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateBoatReservationComponent } from './rate-boat-reservation.component';

describe('RateBoatReservationComponent', () => {
  let component: RateBoatReservationComponent;
  let fixture: ComponentFixture<RateBoatReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RateBoatReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RateBoatReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
