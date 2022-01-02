import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerAddReservationComponent } from './cottage-owner-add-reservation.component';

describe('CottageOwnerAddReservationComponent', () => {
  let component: CottageOwnerAddReservationComponent;
  let fixture: ComponentFixture<CottageOwnerAddReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerAddReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerAddReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
