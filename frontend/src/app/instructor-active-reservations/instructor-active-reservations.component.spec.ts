import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorActiveReservationsComponent } from './instructor-active-reservations.component';

describe('InstructorActiveReservationsComponent', () => {
  let component: InstructorActiveReservationsComponent;
  let fixture: ComponentFixture<InstructorActiveReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorActiveReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorActiveReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
