import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerDeleteProfileComponent } from './boat-owner-delete-profile.component';

describe('BoatOwnerDeleteProfileComponent', () => {
  let component: BoatOwnerDeleteProfileComponent;
  let fixture: ComponentFixture<BoatOwnerDeleteProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerDeleteProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerDeleteProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
