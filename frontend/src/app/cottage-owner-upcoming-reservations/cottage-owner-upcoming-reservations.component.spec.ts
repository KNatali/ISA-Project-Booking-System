import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerUpcomingReservationsComponent } from './cottage-owner-upcoming-reservations.component';

describe('CottageOwnerUpcomingReservationsComponent', () => {
  let component: CottageOwnerUpcomingReservationsComponent;
  let fixture: ComponentFixture<CottageOwnerUpcomingReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerUpcomingReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerUpcomingReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
