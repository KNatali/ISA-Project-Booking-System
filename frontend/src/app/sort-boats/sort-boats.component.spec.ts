import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortBoatsComponent } from './sort-boats.component';

describe('SortBoatsComponent', () => {
  let component: SortBoatsComponent;
  let fixture: ComponentFixture<SortBoatsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortBoatsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortBoatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
