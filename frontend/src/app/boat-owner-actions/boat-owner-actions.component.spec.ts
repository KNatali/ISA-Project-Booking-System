import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerActionsComponent } from './boat-owner-actions.component';

describe('BoatOwnerActionsComponent', () => {
  let component: BoatOwnerActionsComponent;
  let fixture: ComponentFixture<BoatOwnerActionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerActionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
