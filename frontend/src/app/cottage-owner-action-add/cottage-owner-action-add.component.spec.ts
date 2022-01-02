import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerActionAddComponent } from './cottage-owner-action-add.component';

describe('CottageOwnerActionAddComponent', () => {
  let component: CottageOwnerActionAddComponent;
  let fixture: ComponentFixture<CottageOwnerActionAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerActionAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerActionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
