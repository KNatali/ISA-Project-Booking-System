import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorsAdventureListComponent } from './instructors-adventure-list.component';

describe('InstructorsAdventureListComponent', () => {
  let component: InstructorsAdventureListComponent;
  let fixture: ComponentFixture<InstructorsAdventureListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorsAdventureListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorsAdventureListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
