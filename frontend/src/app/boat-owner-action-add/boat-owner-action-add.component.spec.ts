import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerActionAddComponent } from './boat-owner-action-add.component';

describe('BoatOwnerActionAddComponent', () => {
  let component: BoatOwnerActionAddComponent;
  let fixture: ComponentFixture<BoatOwnerActionAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerActionAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerActionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
