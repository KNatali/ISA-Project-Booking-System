import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAdventureListComponent } from './instructor-adventure-list.component';

describe('InstructorAdventureListComponent', () => {
  let component: InstructorAdventureListComponent;
  let fixture: ComponentFixture<InstructorAdventureListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAdventureListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAdventureListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
