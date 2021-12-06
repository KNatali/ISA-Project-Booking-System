import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAddAdventureComponent } from './instructor-add-adventure.component';

describe('InstructorAddAdventureComponent', () => {
  let component: InstructorAddAdventureComponent;
  let fixture: ComponentFixture<InstructorAddAdventureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAddAdventureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAddAdventureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
