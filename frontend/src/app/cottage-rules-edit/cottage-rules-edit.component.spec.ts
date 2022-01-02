import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageRulesEditComponent } from './cottage-rules-edit.component';

describe('CottageRulesEditComponent', () => {
  let component: CottageRulesEditComponent;
  let fixture: ComponentFixture<CottageRulesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageRulesEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageRulesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
