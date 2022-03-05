import { Component, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { AdventureReservationService } from '../service/adventure-reservation.service';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-adventure-reservation-list',
  templateUrl: './adventure-reservation-list.component.html',
  styleUrls: ['./adventure-reservation-list.component.css']
})
export class AdventureReservationListComponent implements OnInit {

  reservations: AdventureReservation[];
  id:any;
  rate_adveture_button=true;//moguce je oceniti samo rezervaciju koja je vec prosla
  constructor(private clientService:ClientService, private adventureReservationService: AdventureReservationService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();

  }
  loadData(){
    this.clientService.findAllAdventureRes(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByDate(){
    this.adventureReservationService.sortByDate(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByPrice(){
    this.adventureReservationService.sortByPrice(this.id)
    .subscribe(res=>this.reservations=res)
  }

}
