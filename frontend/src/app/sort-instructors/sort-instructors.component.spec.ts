import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortInstructorsComponent } from './sort-instructors.component';

describe('SortInstructorsComponent', () => {
  let component: SortInstructorsComponent;
  let fixture: ComponentFixture<SortInstructorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortInstructorsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortInstructorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
