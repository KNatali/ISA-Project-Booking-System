import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedBoatListComponent } from './subscribed-boat-list.component';

describe('SubscribedBoatListComponent', () => {
  let component: SubscribedBoatListComponent;
  let fixture: ComponentFixture<SubscribedBoatListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribedBoatListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedBoatListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
