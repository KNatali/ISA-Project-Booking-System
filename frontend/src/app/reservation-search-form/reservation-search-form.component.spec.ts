import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationSearchFormComponent } from './reservation-search-form.component';

describe('ReservationSearchFormComponent', () => {
  let component: ReservationSearchFormComponent;
  let fixture: ComponentFixture<ReservationSearchFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationSearchFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationSearchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
