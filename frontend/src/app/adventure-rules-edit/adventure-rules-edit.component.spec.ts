import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventureRulesEditComponent } from './adventure-rules-edit.component';

describe('AdventureRulesEditComponent', () => {
  let component: AdventureRulesEditComponent;
  let fixture: ComponentFixture<AdventureRulesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdventureRulesEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventureRulesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
