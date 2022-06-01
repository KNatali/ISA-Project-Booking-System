import { AdditionalItem } from './../model/additionalItem';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { ReserveCottageFastReservation } from '../model/reserveCottageFastReservation';
import { ClientService } from '../service/client.service';
import { CottageReservationService } from '../service/cottage-reservation.service';
import { Client } from '../model/client';

@Component({
  selector: 'tr[app-cottage-action-item]',
  templateUrl: './cottage-action-item.component.html',
  styleUrls: ['./cottage-action-item.component.css']
})
export class CottageActionItemComponent implements OnInit {
  @Input()
  cottageFastReservation:CottageFastReservation;
  @Output()
  reserved:EventEmitter<null>=new EventEmitter();
  constructor(private clientService:ClientService,
    private cottageReservationService: CottageReservationService) { }
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
    reservation :ReserveCottageFastReservation=new ReserveCottageFastReservation({
      id: 0,
      reservationStart: '',
      reservationEnd: '',
      validityStart: '',
      validityEnd: '',
      maxPersons: 0,
      price: 0,
      items:[],
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
    this.reservation.reservationStart=this.cottageFastReservation.reservationStart;
    this.reservation.reservationEnd=this.cottageFastReservation.reservationEnd;
    this.reservation.validityStart=this.cottageFastReservation.validityStart;
    this.reservation.validityEnd=this.cottageFastReservation.validityEnd;
    this.reservation.duration=this.cottageFastReservation.duration;
    this.reservation.maxPersons=this.cottageFastReservation.maxPersons;
    this.reservation.items=this.cottageFastReservation.items;
    this.reservation.client=this.client;
    this.reservation.cottage=this.cottageFastReservation.cottage;
    this.cottageReservationService.reserveCottageFastReservation(this.reservation)
    .subscribe();
    this.reserved.next()
  }
}
