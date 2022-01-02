import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerAddCottageComponent } from './cottage-owner-add-cottage.component';

describe('CottageOwnerAddCottageComponent', () => {
  let component: CottageOwnerAddCottageComponent;
  let fixture: ComponentFixture<CottageOwnerAddCottageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerAddCottageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerAddCottageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
