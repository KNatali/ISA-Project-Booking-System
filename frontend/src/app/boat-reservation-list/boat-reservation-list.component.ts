import { Component, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boat-reservation';
import { BoatReservationService } from '../service/boat-reservation.service';
import { ClientService } from '../service/client.service';


@Component({
  selector: 'app-boat-reservation-list',
  templateUrl: './boat-reservation-list.component.html',
  styleUrls: ['./boat-reservation-list.component.css']
})
export class BoatReservationListComponent implements OnInit {
  reservations: BoatReservation[];
  id:any;
  rate_boat_button=true;
  complain_boat_button=true;
  constructor(private clientService:ClientService, private boatReservationService: BoatReservationService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.clientService.findAllBoatRes(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByDate(){
    this.boatReservationService.sortByDate(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByDuration(){
    this.boatReservationService.sortByDuration(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByPrice(){
    this.boatReservationService.sortByPrice(this.id)
    .subscribe(res=>this.reservations=res)
  }

}
