import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProfileDeleteRequestsComponent } from './admin-profile-delete-requests.component';

describe('AdminProfileDeleteRequestsComponent', () => {
  let component: AdminProfileDeleteRequestsComponent;
  let fixture: ComponentFixture<AdminProfileDeleteRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminProfileDeleteRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProfileDeleteRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
