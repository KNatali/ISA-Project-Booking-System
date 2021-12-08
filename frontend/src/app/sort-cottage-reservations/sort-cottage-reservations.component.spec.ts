import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortCottageReservationsComponent } from './sort-cottage-reservations.component';

describe('SortCottageReservationsComponent', () => {
  let component: SortCottageReservationsComponent;
  let fixture: ComponentFixture<SortCottageReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortCottageReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortCottageReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
