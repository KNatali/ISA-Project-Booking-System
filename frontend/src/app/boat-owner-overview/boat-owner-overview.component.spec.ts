import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerOverviewComponent } from './boat-owner-overview.component';

describe('BoatOwnerOverviewComponent', () => {
  let component: BoatOwnerOverviewComponent;
  let fixture: ComponentFixture<BoatOwnerOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
