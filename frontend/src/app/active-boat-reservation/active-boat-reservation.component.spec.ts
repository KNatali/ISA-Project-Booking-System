import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveBoatReservationComponent } from './active-boat-reservation.component';

describe('ActiveBoatReservationComponent', () => {
  let component: ActiveBoatReservationComponent;
  let fixture: ComponentFixture<ActiveBoatReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActiveBoatReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveBoatReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
