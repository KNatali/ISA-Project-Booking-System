import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerReservationClientComponent } from './cottage-owner-reservation-client.component';

describe('CottageOwnerReservationClientComponent', () => {
  let component: CottageOwnerReservationClientComponent;
  let fixture: ComponentFixture<CottageOwnerReservationClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerReservationClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerReservationClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
