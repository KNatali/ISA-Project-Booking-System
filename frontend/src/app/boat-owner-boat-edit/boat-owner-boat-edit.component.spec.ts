import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerBoatEditComponent } from './boat-owner-boat-edit.component';

describe('BoatOwnerBoatEditComponent', () => {
  let component: BoatOwnerBoatEditComponent;
  let fixture: ComponentFixture<BoatOwnerBoatEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerBoatEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerBoatEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
