import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerCottageEditComponent } from './cottage-owner-cottage-edit.component';

describe('CottageOwnerCottageEditComponent', () => {
  let component: CottageOwnerCottageEditComponent;
  let fixture: ComponentFixture<CottageOwnerCottageEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerCottageEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerCottageEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
