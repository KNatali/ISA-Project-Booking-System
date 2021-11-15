import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatDetailsPageComponent } from './boat-details-page.component';

describe('BoatDetailsPageComponent', () => {
  let component: BoatDetailsPageComponent;
  let fixture: ComponentFixture<BoatDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatDetailsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
