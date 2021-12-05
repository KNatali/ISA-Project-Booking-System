import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAdventureEditComponent } from './instructor-adventure-edit.component';

describe('InstructorAdventureEditComponent', () => {
  let component: InstructorAdventureEditComponent;
  let fixture: ComponentFixture<InstructorAdventureEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAdventureEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAdventureEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
