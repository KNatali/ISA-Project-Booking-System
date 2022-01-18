import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerReservationClientComponent } from './boat-owner-reservation-client.component';

describe('BoatOwnerReservationClientComponent', () => {
  let component: BoatOwnerReservationClientComponent;
  let fixture: ComponentFixture<BoatOwnerReservationClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerReservationClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerReservationClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
