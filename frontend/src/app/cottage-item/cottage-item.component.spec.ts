import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageItemComponent } from './cottage-item.component';

describe('CottageItemComponent', () => {
  let component: CottageItemComponent;
  let fixture: ComponentFixture<CottageItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
