import { Component, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { AdventureReservationService } from '../service/adventure-reservation.service';

@Component({
  selector: 'app-active-adventure-reservation',
  templateUrl: './active-adventure-reservation.component.html',
  styleUrls: ['./active-adventure-reservation.component.css']
})
export class ActiveAdventureReservationComponent implements OnInit {
  reservations:AdventureReservation[];
  id:any;
  constructor(private adventureeReservationService:AdventureReservationService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.adventureeReservationService.activeReservations(this.id)
    .subscribe(res=>this.reservations=res)
  }

}
