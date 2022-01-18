import { Component, Input, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boatReservation';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-completed-reservations',
  templateUrl: './boat-owner-completed-reservations.component.html',
  styleUrls: ['./boat-owner-completed-reservations.component.css']
})
export class BoatOwnerCompletedReservationsComponent implements OnInit {
  completedReservations: BoatReservation[];
  @Input() id: number;
  constructor(private boatOwnerService: BoatOwnerService) { }

  ngOnInit(): void {
    this.getCompletedReservations();
  }

  getCompletedReservations() {
    this.boatOwnerService.getCompletedBoatOwnerReservations(this.id)
      .subscribe(res => this.completedReservations = res)
  }

  addReport(reservation: BoatReservation) {
    sessionStorage.setItem("boatReservation", JSON.stringify(reservation));
  }
}
