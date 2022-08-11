import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedAdventureListComponent } from './subscribed-adventure-list.component';

describe('SubscribedAdventureListComponent', () => {
  let component: SubscribedAdventureListComponent;
  let fixture: ComponentFixture<SubscribedAdventureListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribedAdventureListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedAdventureListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
