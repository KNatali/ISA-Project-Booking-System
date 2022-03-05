import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateIntructorComponent } from './rate-intructor.component';

describe('RateIntructorComponent', () => {
  let component: RateIntructorComponent;
  let fixture: ComponentFixture<RateIntructorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RateIntructorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RateIntructorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
