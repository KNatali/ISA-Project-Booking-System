import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvetureReservationItemComponent } from './adveture-reservation-item.component';

describe('AdvetureReservationItemComponent', () => {
  let component: AdvetureReservationItemComponent;
  let fixture: ComponentFixture<AdvetureReservationItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdvetureReservationItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvetureReservationItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
