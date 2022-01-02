import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerCottageProfileComponent } from './cottage-owner-cottage-profile.component';

describe('CottageOwnerCottageProfileComponent', () => {
  let component: CottageOwnerCottageProfileComponent;
  let fixture: ComponentFixture<CottageOwnerCottageProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerCottageProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerCottageProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
