import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatRulesEditComponent } from './boat-rules-edit.component';

describe('BoatRulesEditComponent', () => {
  let component: BoatRulesEditComponent;
  let fixture: ComponentFixture<BoatRulesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatRulesEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatRulesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
