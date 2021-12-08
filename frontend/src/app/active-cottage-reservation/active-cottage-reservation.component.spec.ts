import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveCottageReservationComponent } from './active-cottage-reservation.component';

describe('ActiveCottageReservationComponent', () => {
  let component: ActiveCottageReservationComponent;
  let fixture: ComponentFixture<ActiveCottageReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActiveCottageReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveCottageReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
