import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventureActionItemComponent } from './adventure-action-item.component';

describe('AdventureActionItemComponent', () => {
  let component: AdventureActionItemComponent;
  let fixture: ComponentFixture<AdventureActionItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdventureActionItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventureActionItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
