import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerPageComponent } from './boat-owner-page.component';

describe('BoatOwnerPageComponent', () => {
  let component: BoatOwnerPageComponent;
  let fixture: ComponentFixture<BoatOwnerPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
