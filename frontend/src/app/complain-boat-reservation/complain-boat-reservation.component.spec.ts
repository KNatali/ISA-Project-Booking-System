import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplainBoatReservationComponent } from './complain-boat-reservation.component';

describe('ComplainBoatReservationComponent', () => {
  let component: ComplainBoatReservationComponent;
  let fixture: ComponentFixture<ComplainBoatReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplainBoatReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplainBoatReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
