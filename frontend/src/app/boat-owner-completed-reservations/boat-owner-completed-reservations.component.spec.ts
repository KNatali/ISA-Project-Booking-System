import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerCompletedReservationsComponent } from './boat-owner-completed-reservations.component';

describe('BoatOwnerCompletedReservationsComponent', () => {
  let component: BoatOwnerCompletedReservationsComponent;
  let fixture: ComponentFixture<BoatOwnerCompletedReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerCompletedReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerCompletedReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
