import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatActionItemComponent } from './boat-action-item.component';

describe('BoatActionItemComponent', () => {
  let component: BoatActionItemComponent;
  let fixture: ComponentFixture<BoatActionItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatActionItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatActionItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
