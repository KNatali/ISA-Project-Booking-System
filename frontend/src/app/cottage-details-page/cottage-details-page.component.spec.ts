import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageDetailsPageComponent } from './cottage-details-page.component';

describe('CottageDetailsPageComponent', () => {
  let component: CottageDetailsPageComponent;
  let fixture: ComponentFixture<CottageDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageDetailsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
