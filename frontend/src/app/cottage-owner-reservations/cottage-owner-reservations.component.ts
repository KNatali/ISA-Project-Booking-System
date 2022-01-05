import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Client } from '../model/client';
import { CottageOwner } from '../model/cottageOwner';
import { CottageReservation } from '../model/cottageReservation';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-reservations',
  templateUrl: './cottage-owner-reservations.component.html',
  styleUrls: ['./cottage-owner-reservations.component.css']
})
export class CottageOwnerReservationsComponent implements OnInit {
  reservations: CottageReservation[];
  completedReservations: CottageReservation[];
  activeReservations: CottageReservation[];
  start: Date = new Date(2021, 10, 12, 7, 0, 0);
  end: Date = new Date(2021, 12, 20, 13, 0, 0);
  client: Client;
  activeTab: string = 'ACTIVE';

  @Input() cottageOwner: CottageOwner = new CottageOwner({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    address: '',
    street: '',
    city: '',
    state: '',
    mobile: ''
  });
  @Input() id: number;
  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private cottageOwnerService: CottageOwnerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      content: ['']
    })
    this.reservations = [];
    this.completedReservations = [];
    this.activeReservations = [];
    this.getReservations();
    this.getCompletedReservations()
    this.getActiveReservations();
  }
  changeTab(tabName: string) {
    this.activeTab = tabName;
  }

  getReservations() {
    this.cottageOwnerService.getCottageOwnerReservations(this.id)
      .subscribe(res => this.reservations = res)
  }

  getCompletedReservations() {
    this.cottageOwnerService.getCompletedCottageOwnerReservations(this.id)
      .subscribe(res => this.completedReservations = res)
  }
  getActiveReservations() {
    this.cottageOwnerService.getActiveCottageOwnerReservations(this.id)
      .subscribe(res => this.activeReservations = res)
  }

}
