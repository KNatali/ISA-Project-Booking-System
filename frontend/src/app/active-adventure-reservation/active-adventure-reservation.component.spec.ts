import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveAdventureReservationComponent } from './active-adventure-reservation.component';

describe('ActiveAdventureReservationComponent', () => {
  let component: ActiveAdventureReservationComponent;
  let fixture: ComponentFixture<ActiveAdventureReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActiveAdventureReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveAdventureReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
