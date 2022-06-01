import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatActionListComponent } from './boat-action-list.component';

describe('BoatActionListComponent', () => {
  let component: BoatActionListComponent;
  let fixture: ComponentFixture<BoatActionListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatActionListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatActionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
