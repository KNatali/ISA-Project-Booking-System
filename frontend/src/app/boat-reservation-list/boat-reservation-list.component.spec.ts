import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatReservationListComponent } from './boat-reservation-list.component';

describe('BoatReservationListComponent', () => {
  let component: BoatReservationListComponent;
  let fixture: ComponentFixture<BoatReservationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatReservationListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatReservationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
