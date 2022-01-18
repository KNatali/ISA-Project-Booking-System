import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerAddReservationComponent } from './boat-owner-add-reservation.component';

describe('BoatOwnerAddReservationComponent', () => {
  let component: BoatOwnerAddReservationComponent;
  let fixture: ComponentFixture<BoatOwnerAddReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerAddReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerAddReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
