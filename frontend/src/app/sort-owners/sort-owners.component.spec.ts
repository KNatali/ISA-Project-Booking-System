import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortOwnersComponent } from './sort-owners.component';

describe('SortOwnersComponent', () => {
  let component: SortOwnersComponent;
  let fixture: ComponentFixture<SortOwnersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortOwnersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortOwnersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
