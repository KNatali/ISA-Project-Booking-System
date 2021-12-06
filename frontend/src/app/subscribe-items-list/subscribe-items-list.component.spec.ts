import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribeItemsListComponent } from './subscribe-items-list.component';

describe('SubscribeItemsListComponent', () => {
  let component: SubscribeItemsListComponent;
  let fixture: ComponentFixture<SubscribeItemsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribeItemsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribeItemsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
