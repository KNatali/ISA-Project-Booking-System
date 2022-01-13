import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Address } from '../model/address';
import { BoatOwner } from '../model/boatOwner';
import { BoatReservation } from '../model/boatReservation';
import { Client } from '../model/client';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-reservations',
  templateUrl: './boat-owner-reservations.component.html',
  styleUrls: ['./boat-owner-reservations.component.css']
})
export class BoatOwnerReservationsComponent implements OnInit {
  reservations: BoatReservation[];
  completedReservations: BoatReservation[];
  activeReservations: BoatReservation[];
  start: Date = new Date(2021, 10, 12, 7, 0, 0);
  end: Date = new Date(2021, 12, 20, 13, 0, 0);
  client: Client;
  activeTab: string = 'ACTIVE';


  @Input() boatOwner: BoatOwner = new BoatOwner({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: '',
    address: '',
    grade: 0

  });
  @Input() id: number;
  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private boatOwnerService: BoatOwnerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      content: ['']
    })

  }
  changeTab(tabName: string) {
    this.activeTab = tabName;
  }

}
