import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageActionItemComponent } from './cottage-action-item.component';

describe('CottageActionItemComponent', () => {
  let component: CottageActionItemComponent;
  let fixture: ComponentFixture<CottageActionItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageActionItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageActionItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
