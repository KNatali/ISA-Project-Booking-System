import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerReservationsComponent } from './cottage-owner-reservations.component';

describe('CottageOwnerReservationsComponent', () => {
  let component: CottageOwnerReservationsComponent;
  let fixture: ComponentFixture<CottageOwnerReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
