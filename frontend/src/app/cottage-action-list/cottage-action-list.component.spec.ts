import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageActionListComponent } from './cottage-action-list.component';

describe('CottageActionListComponent', () => {
  let component: CottageActionListComponent;
  let fixture: ComponentFixture<CottageActionListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageActionListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageActionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
