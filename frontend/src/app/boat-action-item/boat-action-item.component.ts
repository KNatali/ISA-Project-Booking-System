import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
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
  @Output()
  reserved:EventEmitter<null>=new EventEmitter();
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
  Reserve(){
    this.reservation.id=this.boatFastReservation.id;
    this.reservation.reservationStart=this.boatFastReservation.reservationStart;
    this.reservation.reservationEnd=this.boatFastReservation.reservationEnd;
    this.reservation.validityStart=this.boatFastReservation.validityStart;
    this.reservation.validityEnd=this.boatFastReservation.validityEnd;
    this.reservation.duration=this.boatFastReservation.duration;
    this.reservation.maxPersons=this.boatFastReservation.maxPersons;
    this.reservation.additionalItems=this.boatFastReservation.additionalItems;
    this.reservation.client=this.client;
    this.reservation.boat=this.boatFastReservation.boat;
    this.boatReservationService.reserveBoatFastReservation(this.reservation)
    .subscribe(res=>this.reserved.next());

  }

}
