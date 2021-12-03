import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAdventureProfileComponent } from './instructor-adventure-profile.component';

describe('InstructorAdventureProfileComponent', () => {
  let component: InstructorAdventureProfileComponent;
  let fixture: ComponentFixture<InstructorAdventureProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAdventureProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAdventureProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
