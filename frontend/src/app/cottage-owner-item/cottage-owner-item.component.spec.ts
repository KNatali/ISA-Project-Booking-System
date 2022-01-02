import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerItemComponent } from './cottage-owner-item.component';

describe('CottageOwnerItemComponent', () => {
  let component: CottageOwnerItemComponent;
  let fixture: ComponentFixture<CottageOwnerItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
