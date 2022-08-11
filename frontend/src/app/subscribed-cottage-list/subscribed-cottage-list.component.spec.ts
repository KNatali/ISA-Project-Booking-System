import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedCottageListComponent } from './subscribed-cottage-list.component';

describe('SubscribedCottageListComponent', () => {
  let component: SubscribedCottageListComponent;
  let fixture: ComponentFixture<SubscribedCottageListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribedCottageListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedCottageListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
