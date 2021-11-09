import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageListItemComponent } from './cottage-list-item.component';

describe('CottageListItemComponent', () => {
  let component: CottageListItemComponent;
  let fixture: ComponentFixture<CottageListItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageListItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
