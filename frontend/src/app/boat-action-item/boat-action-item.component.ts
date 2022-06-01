import { Component, Input, OnInit } from '@angular/core';
import { BoatFastReservation } from '../model/boatFastReservation';
import { Client } from '../model/client';
import { ReserveBoatFastReservation } from '../model/reserveBoatFastReservation';
import { BoatReservationService } from '../service/boat-reservation.service';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'tr[app-boat-action-item]',
  templateUrl: './boat-action-item.component.html',
  styleUrls: ['./boat-action-item.component.css']
})
export class BoatActionItemComponent implements OnInit {
  @Input()
  boatFastReservation:BoatFastReservation;
  constructor(private clientService:ClientService,
    private boatReservationService: BoatReservationService
) { }
  client: Client = new Client({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: ''
  });
  reservation :ReserveBoatFastReservation=new ReserveBoatFastReservation({
    id: 0,
    reservationStart:'',
    reservationEnd:'',
    validityStart:'',
    validityEnd:'',
    maxPersons:0,
    price:0,
    additionalItems:[],
    duration:0,
    client:this.client
  });
  id:any;
  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadClient();
   }
  loadClient(){
    this.clientService.getById(this.id)
      .subscribe(res => this.client = res)
  }
  Reserve(){}

}
