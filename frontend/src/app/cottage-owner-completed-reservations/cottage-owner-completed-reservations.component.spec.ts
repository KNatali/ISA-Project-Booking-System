import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerCompletedReservationsComponent } from './cottage-owner-completed-reservations.component';

describe('CottageOwnerCompletedReservationsComponent', () => {
  let component: CottageOwnerCompletedReservationsComponent;
  let fixture: ComponentFixture<CottageOwnerCompletedReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerCompletedReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerCompletedReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
