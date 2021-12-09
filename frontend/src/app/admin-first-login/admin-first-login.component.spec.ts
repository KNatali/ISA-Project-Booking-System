import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFirstLoginComponent } from './admin-first-login.component';

describe('AdminFirstLoginComponent', () => {
  let component: AdminFirstLoginComponent;
  let fixture: ComponentFixture<AdminFirstLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFirstLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFirstLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
