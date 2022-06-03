import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { CottageReservationListComponent } from '../cottage-reservation-list/cottage-reservation-list.component';
import { Cottage } from '../model/cottage';
import { CottageReservation } from '../model/cottage-reservation';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'tr[app-cottage-reservation-item]',
  templateUrl: './cottage-reservation-item.component.html',
  styleUrls: ['./cottage-reservation-item.component.css']
})
export class CottageReservationItemComponent implements OnInit {
  @Input()
  res:CottageReservation;
  @Input()
  delete_cottage_button:boolean;
  @Input()
  rate_cottage_button:boolean;
  @Input()
  complain_cottage_button:boolean;
  @Output()
  canceledReservaiton:EventEmitter<number>=new EventEmitter();
  constructor() {}

  ngOnInit(): void {
  }
  cancelReservation(){
    this.canceledReservaiton.next(this.res.id);
  }

}
