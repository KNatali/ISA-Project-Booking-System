import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientDeleteProfilComponent } from './client-delete-profil.component';

describe('ClientDeleteProfilComponent', () => {
  let component: ClientDeleteProfilComponent;
  let fixture: ComponentFixture<ClientDeleteProfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientDeleteProfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientDeleteProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
