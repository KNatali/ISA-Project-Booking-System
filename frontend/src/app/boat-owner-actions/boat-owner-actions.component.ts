import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { BoatFastReservation } from '../model/boatFastReservation';
import { BoatOwner } from '../model/boatOwner';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-actions',
  templateUrl: './boat-owner-actions.component.html',
  styleUrls: ['./boat-owner-actions.component.css']
})
export class BoatOwnerActionsComponent implements OnInit {
  fastReservations: BoatFastReservation[];
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
  constructor(private formBuilder: FormBuilder, private boatOwnerService: BoatOwnerService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.fastReservations = [];

    this.getFastReservations();

  }

  getFastReservations() {
    this.boatOwnerService.getBoatOwnerFastReservations(this.id)
      .subscribe(res => this.fastReservations = res)
  }

}
