import { Component, Input, OnInit } from '@angular/core';
import { CottageReservation } from '../model/cottageReservation';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-active-reservations',
  templateUrl: './cottage-owner-active-reservations.component.html',
  styleUrls: ['./cottage-owner-active-reservations.component.css']
})
export class CottageOwnerActiveReservationsComponent implements OnInit {
  @Input() id: number;
  activeReservations: CottageReservation[];
  constructor(private cottageOwnerService: CottageOwnerService) { }

  ngOnInit(): void {
    this.getActiveReservations();
  }
  getActiveReservations() {
    this.cottageOwnerService.getActiveCottageOwnerReservations(this.id)
      .subscribe(res => this.activeReservations = res)
  }

  saveCurrentReservation(reservation: CottageReservation) {
    sessionStorage.setItem("currentReservation", JSON.stringify(reservation));
  }
}
