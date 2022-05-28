import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplainInstructorComponent } from './complain-instructor.component';

describe('ComplainInstructorComponent', () => {
  let component: ComplainInstructorComponent;
  let fixture: ComponentFixture<ComplainInstructorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplainInstructorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplainInstructorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
