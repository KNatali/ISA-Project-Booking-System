import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventureAdditionalItemsEditComponent } from './adventure-additional-items-edit.component';

describe('AdventureAdditionalItemsEditComponent', () => {
  let component: AdventureAdditionalItemsEditComponent;
  let fixture: ComponentFixture<AdventureAdditionalItemsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdventureAdditionalItemsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventureAdditionalItemsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
