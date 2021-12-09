import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailableBoatTermsItemComponent } from './available-boat-terms-item.component';

describe('AvailableBoatTermsItemComponent', () => {
  let component: AvailableBoatTermsItemComponent;
  let fixture: ComponentFixture<AvailableBoatTermsItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailableBoatTermsItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailableBoatTermsItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
