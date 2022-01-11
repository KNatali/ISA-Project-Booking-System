import { Component, Input, OnInit } from '@angular/core';
import { CottageReservation } from '../model/cottageReservation';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-upcoming-reservations',
  templateUrl: './cottage-owner-upcoming-reservations.component.html',
  styleUrls: ['./cottage-owner-upcoming-reservations.component.css']
})
export class CottageOwnerUpcomingReservationsComponent implements OnInit {
  reservations: CottageReservation[];
  @Input() id: number;
  constructor(private cottageOwnerService: CottageOwnerService) { }

  ngOnInit(): void {
    this.getReservations();
  }
  getReservations() {
    this.cottageOwnerService.getUpcomingCottageOwnerReservations(this.id)
      .subscribe(res => this.reservations = res)
  }

}
