import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatReservationItemComponent } from './boat-reservation-item.component';

describe('BoatReservationItemComponent', () => {
  let component: BoatReservationItemComponent;
  let fixture: ComponentFixture<BoatReservationItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatReservationItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatReservationItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
