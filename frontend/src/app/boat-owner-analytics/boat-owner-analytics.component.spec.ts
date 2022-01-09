import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerAnalyticsComponent } from './boat-owner-analytics.component';

describe('BoatOwnerAnalyticsComponent', () => {
  let component: BoatOwnerAnalyticsComponent;
  let fixture: ComponentFixture<BoatOwnerAnalyticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerAnalyticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerAnalyticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
