import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailableBoatTermsListComponent } from './available-boat-terms-list.component';

describe('AvailableBoatTermsListComponent', () => {
  let component: AvailableBoatTermsListComponent;
  let fixture: ComponentFixture<AvailableBoatTermsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailableBoatTermsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailableBoatTermsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
