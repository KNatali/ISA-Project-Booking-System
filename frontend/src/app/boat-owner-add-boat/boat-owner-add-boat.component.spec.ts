import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatOwnerAddBoatComponent } from './boat-owner-add-boat.component';

describe('BoatOwnerAddBoatComponent', () => {
  let component: BoatOwnerAddBoatComponent;
  let fixture: ComponentFixture<BoatOwnerAddBoatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatOwnerAddBoatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatOwnerAddBoatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
