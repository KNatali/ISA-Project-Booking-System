import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminClientComplaintsComponent } from './admin-client-complaints.component';

describe('AdminClientComplaintsComponent', () => {
  let component: AdminClientComplaintsComponent;
  let fixture: ComponentFixture<AdminClientComplaintsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminClientComplaintsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminClientComplaintsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
