import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerActionsComponent } from './cottage-owner-actions.component';

describe('CottageOwnerActionsComponent', () => {
  let component: CottageOwnerActionsComponent;
  let fixture: ComponentFixture<CottageOwnerActionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerActionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
