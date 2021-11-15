import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchCottageComponent } from './search-cottage.component';

describe('SearchCottageComponent', () => {
  let component: SearchCottageComponent;
  let fixture: ComponentFixture<SearchCottageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchCottageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchCottageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
