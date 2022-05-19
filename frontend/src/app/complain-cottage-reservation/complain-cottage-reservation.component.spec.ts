import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplainCottageReservationComponent } from './complain-cottage-reservation.component';

describe('ComplainCottageReservationComponent', () => {
  let component: ComplainCottageReservationComponent;
  let fixture: ComponentFixture<ComplainCottageReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplainCottageReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplainCottageReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
