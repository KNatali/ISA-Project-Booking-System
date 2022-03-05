import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateCottageReservationComponent } from './rate-cottage-reservation.component';

describe('RateCottageReservationComponent', () => {
  let component: RateCottageReservationComponent;
  let fixture: ComponentFixture<RateCottageReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RateCottageReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RateCottageReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
