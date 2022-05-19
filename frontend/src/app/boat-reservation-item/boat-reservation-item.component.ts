import { Component, Input, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boat-reservation';

@Component({
  selector: 'tr[app-boat-reservation-item]',
  templateUrl: './boat-reservation-item.component.html',
  styleUrls: ['./boat-reservation-item.component.css']
})
export class BoatReservationItemComponent implements OnInit {
  @Input()
  res:BoatReservation;
  @Input()
  rate_boat_button:boolean;
  @Input()
  complain_boat_button:boolean;
  constructor() { }

  ngOnInit(): void {
  }

}
