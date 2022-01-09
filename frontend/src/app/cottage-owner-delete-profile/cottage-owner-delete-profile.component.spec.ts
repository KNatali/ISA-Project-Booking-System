import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerDeleteProfileComponent } from './cottage-owner-delete-profile.component';

describe('CottageOwnerDeleteProfileComponent', () => {
  let component: CottageOwnerDeleteProfileComponent;
  let fixture: ComponentFixture<CottageOwnerDeleteProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerDeleteProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerDeleteProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
