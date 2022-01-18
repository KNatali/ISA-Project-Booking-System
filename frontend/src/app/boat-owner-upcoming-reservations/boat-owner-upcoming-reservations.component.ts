import { Component, Input, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boatReservation';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-upcoming-reservations',
  templateUrl: './boat-owner-upcoming-reservations.component.html',
  styleUrls: ['./boat-owner-upcoming-reservations.component.css']
})
export class BoatOwnerUpcomingReservationsComponent implements OnInit {
  reservations: BoatReservation[];
  @Input() id: number;
  constructor(private boatOwnerService: BoatOwnerService) { }

  ngOnInit(): void {
    this.getReservations();
  }
  getReservations() {
    this.boatOwnerService.getUpcomingBoatOwnerReservations(this.id)
      .subscribe(res => this.reservations = res)
  }

}
