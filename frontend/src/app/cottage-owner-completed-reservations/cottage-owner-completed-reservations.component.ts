import { Component, Input, OnInit } from '@angular/core';
import { CottageReservation } from '../model/cottageReservation';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-completed-reservations',
  templateUrl: './cottage-owner-completed-reservations.component.html',
  styleUrls: ['./cottage-owner-completed-reservations.component.css']
})
export class CottageOwnerCompletedReservationsComponent implements OnInit {
  completedReservations: CottageReservation[];
  @Input() id: number;
  constructor(private cottageOwnerService: CottageOwnerService) { }

  ngOnInit(): void {
    this.getCompletedReservations();
  }

  getCompletedReservations() {
    this.cottageOwnerService.getCompletedCottageOwnerReservations(this.id)
      .subscribe(res => this.completedReservations = res)
  }

  addReport(reservation: CottageReservation) {
    sessionStorage.setItem("cottageReservation", JSON.stringify(reservation));
  }

}
