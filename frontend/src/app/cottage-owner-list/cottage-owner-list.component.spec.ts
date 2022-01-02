import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerListComponent } from './cottage-owner-list.component';

describe('CottageOwnerListComponent', () => {
  let component: CottageOwnerListComponent;
  let fixture: ComponentFixture<CottageOwnerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
