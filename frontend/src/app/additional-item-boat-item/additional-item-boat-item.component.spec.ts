import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionalItemBoatItemComponent } from './additional-item-boat-item.component';

describe('AdditionalItemBoatItemComponent', () => {
  let component: AdditionalItemBoatItemComponent;
  let fixture: ComponentFixture<AdditionalItemBoatItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdditionalItemBoatItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdditionalItemBoatItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
