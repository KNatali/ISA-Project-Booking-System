import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventureDatailsPageComponent } from './adventure-datails-page.component';

describe('AdventureDatailsPageComponent', () => {
  let component: AdventureDatailsPageComponent;
  let fixture: ComponentFixture<AdventureDatailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdventureDatailsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventureDatailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
