import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerActiveReservationsComponent } from './cottage-owner-active-reservations.component';

describe('CottageOwnerActiveReservationsComponent', () => {
  let component: CottageOwnerActiveReservationsComponent;
  let fixture: ComponentFixture<CottageOwnerActiveReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerActiveReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerActiveReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
