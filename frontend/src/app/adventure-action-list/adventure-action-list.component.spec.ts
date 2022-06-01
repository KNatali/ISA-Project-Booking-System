import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventureActionListComponent } from './adventure-action-list.component';

describe('AdventureActionListComponent', () => {
  let component: AdventureActionListComponent;
  let fixture: ComponentFixture<AdventureActionListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdventureActionListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventureActionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
