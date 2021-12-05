import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventureEquipmentEditComponent } from './adventure-equipment-edit.component';

describe('AdventureEquipmentEditComponent', () => {
  let component: AdventureEquipmentEditComponent;
  let fixture: ComponentFixture<AdventureEquipmentEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdventureEquipmentEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventureEquipmentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
