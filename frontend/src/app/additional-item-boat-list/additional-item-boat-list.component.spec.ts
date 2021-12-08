import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionalItemBoatListComponent } from './additional-item-boat-list.component';

describe('AdditionalItemBoatListComponent', () => {
  let component: AdditionalItemBoatListComponent;
  let fixture: ComponentFixture<AdditionalItemBoatListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdditionalItemBoatListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdditionalItemBoatListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
