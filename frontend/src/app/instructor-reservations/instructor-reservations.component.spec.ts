import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorReservationsComponent } from './instructor-reservations.component';

describe('InstructorReservationsComponent', () => {
  let component: InstructorReservationsComponent;
  let fixture: ComponentFixture<InstructorReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
