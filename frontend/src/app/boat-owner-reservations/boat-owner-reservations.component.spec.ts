import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerReservationsComponent } from './boat-owner-reservations.component';

describe('BoatOwnerReservationsComponent', () => {
  let component: BoatOwnerReservationsComponent;
  let fixture: ComponentFixture<BoatOwnerReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
