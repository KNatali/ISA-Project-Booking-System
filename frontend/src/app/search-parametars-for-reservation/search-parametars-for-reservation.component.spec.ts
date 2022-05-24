import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchParametarsForReservationComponent } from './search-parametars-for-reservation.component';

describe('SearchParametarsForReservationComponent', () => {
  let component: SearchParametarsForReservationComponent;
  let fixture: ComponentFixture<SearchParametarsForReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchParametarsForReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchParametarsForReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
