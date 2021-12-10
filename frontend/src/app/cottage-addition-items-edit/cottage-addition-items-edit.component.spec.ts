import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageAdditionItemsEditComponent } from './cottage-addition-items-edit.component';

describe('CottageAdditionItemsEditComponent', () => {
  let component: CottageAdditionItemsEditComponent;
  let fixture: ComponentFixture<CottageAdditionItemsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageAdditionItemsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageAdditionItemsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
