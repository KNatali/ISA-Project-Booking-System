import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorReservationClientComponent } from './instructor-reservation-client.component';

describe('InstructorReservationClientComponent', () => {
  let component: InstructorReservationClientComponent;
  let fixture: ComponentFixture<InstructorReservationClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorReservationClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorReservationClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
