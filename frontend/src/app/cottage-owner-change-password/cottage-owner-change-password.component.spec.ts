import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerChangePasswordComponent } from './cottage-owner-change-password.component';

describe('CottageOwnerChangePasswordComponent', () => {
  let component: CottageOwnerChangePasswordComponent;
  let fixture: ComponentFixture<CottageOwnerChangePasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerChangePasswordComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerChangePasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
