import { Component, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boat-reservation';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-boat-reservation-list',
  templateUrl: './boat-reservation-list.component.html',
  styleUrls: ['./boat-reservation-list.component.css']
})
export class BoatReservationListComponent implements OnInit {
  reservations: BoatReservation[];
  id:any;
  constructor(private clientService:ClientService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.clientService.findAllBoatRes(this.id)
    .subscribe(res=>this.reservations=res)
  }

}
