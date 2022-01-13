import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatAdditionItemsEditComponent } from './boat-addition-items-edit.component';

describe('BoatAdditionItemsEditComponent', () => {
  let component: BoatAdditionItemsEditComponent;
  let fixture: ComponentFixture<BoatAdditionItemsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatAdditionItemsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatAdditionItemsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
