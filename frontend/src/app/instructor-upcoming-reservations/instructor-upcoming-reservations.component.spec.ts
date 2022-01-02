import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorUpcomingReservationsComponent } from './instructor-upcoming-reservations.component';

describe('InstructorUpcomingReservationsComponent', () => {
  let component: InstructorUpcomingReservationsComponent;
  let fixture: ComponentFixture<InstructorUpcomingReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorUpcomingReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorUpcomingReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
