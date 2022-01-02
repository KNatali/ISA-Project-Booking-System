import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerOverviewComponent } from './cottage-owner-overview.component';

describe('CottageOwnerOverviewComponent', () => {
  let component: CottageOwnerOverviewComponent;
  let fixture: ComponentFixture<CottageOwnerOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
