import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAddReservationComponent } from './instructor-add-reservation.component';

describe('InstructorAddReservationComponent', () => {
  let component: InstructorAddReservationComponent;
  let fixture: ComponentFixture<InstructorAddReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAddReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAddReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
