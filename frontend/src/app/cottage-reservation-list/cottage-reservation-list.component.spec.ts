import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageReservationListComponent } from './cottage-reservation-list.component';

describe('CottageReservationListComponent', () => {
  let component: CottageReservationListComponent;
  let fixture: ComponentFixture<CottageReservationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageReservationListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageReservationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
