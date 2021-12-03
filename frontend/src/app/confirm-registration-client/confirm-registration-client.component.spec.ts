import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmRegistrationClientComponent } from './confirm-registration-client.component';

describe('ConfirmRegistrationClientComponent', () => {
  let component: ConfirmRegistrationClientComponent;
  let fixture: ComponentFixture<ConfirmRegistrationClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmRegistrationClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmRegistrationClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
