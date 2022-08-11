import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchAvailableEntitisComponent } from './search-available-entitis.component';

describe('SearchAvailableEntitisComponent', () => {
  let component: SearchAvailableEntitisComponent;
  let fixture: ComponentFixture<SearchAvailableEntitisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchAvailableEntitisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchAvailableEntitisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
