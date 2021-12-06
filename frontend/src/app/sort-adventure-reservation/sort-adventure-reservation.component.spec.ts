import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortAdventureReservationComponent } from './sort-adventure-reservation.component';

describe('SortAdventureReservationComponent', () => {
  let component: SortAdventureReservationComponent;
  let fixture: ComponentFixture<SortAdventureReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortAdventureReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortAdventureReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
