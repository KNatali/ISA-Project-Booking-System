import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerChangePasswordComponent } from './boat-owner-change-password.component';

describe('BoatOwnerChangePasswordComponent', () => {
  let component: BoatOwnerChangePasswordComponent;
  let fixture: ComponentFixture<BoatOwnerChangePasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerChangePasswordComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerChangePasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
