import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchAdventureComponent } from './search-adventure.component';

describe('SearchAdventureComponent', () => {
  let component: SearchAdventureComponent;
  let fixture: ComponentFixture<SearchAdventureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchAdventureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchAdventureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
