import { Component, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-adventure-reservation-list',
  templateUrl: './adventure-reservation-list.component.html',
  styleUrls: ['./adventure-reservation-list.component.css']
})
export class AdventureReservationListComponent implements OnInit {

  reservations: AdventureReservation[];
  id:any;
  constructor(private clientService:ClientService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.clientService.findAllAdventureRes(this.id)
    .subscribe(res=>this.reservations=res)
  }

}
