import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageListPageComponent } from './cottage-list-page.component';

describe('CottageListPageComponent', () => {
  let component: CottageListPageComponent;
  let fixture: ComponentFixture<CottageListPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageListPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
