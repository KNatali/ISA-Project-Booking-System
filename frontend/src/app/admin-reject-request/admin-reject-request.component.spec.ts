import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRejectRequestComponent } from './admin-reject-request.component';

describe('AdminRejectRequestComponent', () => {
  let component: AdminRejectRequestComponent;
  let fixture: ComponentFixture<AdminRejectRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminRejectRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminRejectRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
