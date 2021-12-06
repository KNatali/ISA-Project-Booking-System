import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortCottagesComponent } from './sort-cottages.component';

describe('SortCottagesComponent', () => {
  let component: SortCottagesComponent;
  let fixture: ComponentFixture<SortCottagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortCottagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortCottagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
