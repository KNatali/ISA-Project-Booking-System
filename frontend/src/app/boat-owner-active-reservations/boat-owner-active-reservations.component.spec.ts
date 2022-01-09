import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerActiveReservationsComponent } from './boat-owner-active-reservations.component';

describe('BoatOwnerActiveReservationsComponent', () => {
  let component: BoatOwnerActiveReservationsComponent;
  let fixture: ComponentFixture<BoatOwnerActiveReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerActiveReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerActiveReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
