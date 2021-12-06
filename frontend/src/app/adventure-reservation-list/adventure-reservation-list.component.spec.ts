import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventureReservationListComponent } from './adventure-reservation-list.component';

describe('AdventureReservationListComponent', () => {
  let component: AdventureReservationListComponent;
  let fixture: ComponentFixture<AdventureReservationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdventureReservationListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventureReservationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
