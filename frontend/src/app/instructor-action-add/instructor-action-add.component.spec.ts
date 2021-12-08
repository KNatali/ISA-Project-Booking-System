import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorActionAddComponent } from './instructor-action-add.component';

describe('InstructorActionAddComponent', () => {
  let component: InstructorActionAddComponent;
  let fixture: ComponentFixture<InstructorActionAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorActionAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorActionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
