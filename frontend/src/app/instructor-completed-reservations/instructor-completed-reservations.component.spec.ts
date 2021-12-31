import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorCompletedReservationsComponent } from './instructor-completed-reservations.component';

describe('InstructorCompletedReservationsComponent', () => {
  let component: InstructorCompletedReservationsComponent;
  let fixture: ComponentFixture<InstructorCompletedReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorCompletedReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorCompletedReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
