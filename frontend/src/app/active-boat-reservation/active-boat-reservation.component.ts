import { Component, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boat-reservation';
import { BoatReservationService } from '../service/boat-reservation.service';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-active-boat-reservation',
  templateUrl: './active-boat-reservation.component.html',
  styleUrls: ['./active-boat-reservation.component.css']
})
export class ActiveBoatReservationComponent implements OnInit {
  reservations:BoatReservation[];
  id:any;
  delete_boat_button:boolean=true;
  constructor(private boatReservationService:BoatReservationService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.boatReservationService.activeReservation(this.id)
    .subscribe(res=>this.reservations=res)
  }
  canceledReservaiton(resId:number){
    this.boatReservationService.cancelReservation(resId)
    .subscribe(res=>this.loadData());
  }

}
