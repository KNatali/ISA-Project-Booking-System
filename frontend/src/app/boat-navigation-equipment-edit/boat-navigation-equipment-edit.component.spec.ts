import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatNavigationEquipmentEditComponent } from './boat-navigation-equipment-edit.component';

describe('BoatNavigationEquipmentEditComponent', () => {
  let component: BoatNavigationEquipmentEditComponent;
  let fixture: ComponentFixture<BoatNavigationEquipmentEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatNavigationEquipmentEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatNavigationEquipmentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
