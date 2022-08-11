import { AdventureReservationService } from './../service/adventure-reservation.service';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';

@Component({
  selector: 'tr[app-adveture-reservation-item]',
  templateUrl: './adveture-reservation-item.component.html',
  styleUrls: ['./adveture-reservation-item.component.css']
})
export class AdvetureReservationItemComponent implements OnInit {
  @Input()
  res:AdventureReservation;
  @Input()
  rate_adveture_button:boolean;
  @Input()
  delete_adveture_button:boolean;
  @Input()
  complaint_adveture_button:boolean;
  @Output()
  canceledReservaiton:EventEmitter<number>=new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }
  cancelReservation(){
    this.canceledReservaiton.next(this.res.id);
  }
}
