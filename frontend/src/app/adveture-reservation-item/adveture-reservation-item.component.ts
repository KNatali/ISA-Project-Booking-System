import { Component, OnInit , Input} from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';

@Component({
  selector: 'tr[app-adveture-reservation-item]',
  templateUrl: './adveture-reservation-item.component.html',
  styleUrls: ['./adveture-reservation-item.component.css']
})
export class AdvetureReservationItemComponent implements OnInit {
  @Input()
  res:AdventureReservation;
  
  constructor() { }

  ngOnInit(): void {
  }

}
