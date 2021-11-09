import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatListPageComponent } from './boat-list-page.component';

describe('BoatListPageComponent', () => {
  let component: BoatListPageComponent;
  let fixture: ComponentFixture<BoatListPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoatListPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoatListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
