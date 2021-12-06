import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageReservationItemComponent } from './cottage-reservation-item.component';

describe('CottageReservationItemComponent', () => {
  let component: CottageReservationItemComponent;
  let fixture: ComponentFixture<CottageReservationItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageReservationItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageReservationItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
