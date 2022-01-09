import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerAnalyticsComponent } from './cottage-owner-analytics.component';

describe('CottageOwnerAnalyticsComponent', () => {
  let component: CottageOwnerAnalyticsComponent;
  let fixture: ComponentFixture<CottageOwnerAnalyticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerAnalyticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerAnalyticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
