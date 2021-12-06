import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortBoatReservationsComponent } from './sort-boat-reservations.component';

describe('SortBoatReservationsComponent', () => {
  let component: SortBoatReservationsComponent;
  let fixture: ComponentFixture<SortBoatReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortBoatReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortBoatReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
