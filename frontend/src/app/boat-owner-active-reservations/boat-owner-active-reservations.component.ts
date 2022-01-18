import { Component, Input, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boatReservation';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-active-reservations',
  templateUrl: './boat-owner-active-reservations.component.html',
  styleUrls: ['./boat-owner-active-reservations.component.css']
})
export class BoatOwnerActiveReservationsComponent implements OnInit {
  @Input() id: number;
  activeReservations: BoatReservation[];
  constructor(private boatOwnerService: BoatOwnerService) { }

  ngOnInit(): void {
    this.getActiveReservations();
  }
  getActiveReservations() {
    this.boatOwnerService.getActiveBoatOwnerReservations(this.id)
      .subscribe(res => this.activeReservations = res)
  }

  saveCurrentReservation(reservation: BoatReservation) {
    sessionStorage.setItem("currentReservation", JSON.stringify(reservation));
  }

}
