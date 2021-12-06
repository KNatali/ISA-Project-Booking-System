import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribeItemComponent } from './subscribe-item.component';

describe('SubscribeItemComponent', () => {
  let component: SubscribeItemComponent;
  let fixture: ComponentFixture<SubscribeItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribeItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribeItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
