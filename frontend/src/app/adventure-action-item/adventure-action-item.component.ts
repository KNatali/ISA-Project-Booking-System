import { AdventureReservationService } from './../service/adventure-reservation.service';
import { AdventureReservation } from './../model/AdventureReservation';
import { ReserveAdventureFastReservation } from './../model/reserveAdventureFastReservation';
import { ClientService } from './../service/client.service';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { AdventureFastReservation, AdventureFastReservationInterface } from '../model/adventureFastReservation';
import { Client } from '../model/client';
import { Adventure } from '../model/adventure';

@Component({
  selector: 'tr[app-adventure-action-item]',
  templateUrl: './adventure-action-item.component.html',
  styleUrls: ['./adventure-action-item.component.css']
})
export class AdventureActionItemComponent implements OnInit {
  @Input()
  adventureFastReservation:AdventureFastReservation;
  @Input()
  normal_price:number;
  @Input()
  startReseration:string;
  @Input()
  endReseration:string;
  @Output()
  Reserved: EventEmitter<void>=new EventEmitter();
  startDate:Date = new Date();
  endDate:Date = new Date();
  startDay:number;
  endDay:number;
  duration:number;
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
  reservation :ReserveAdventureFastReservation=new ReserveAdventureFastReservation({
    id: 0,
    reservationStart:'',
    reservationEnd:'',
    validityStart:'',
    validityEnd:'',
    maxPersons:0,
    price:0,
    additionalItems:[],
    durationHours:0,
    client:this.client
  });
  id:any;

  constructor(private clientService:ClientService,
              private adventureReservationService: AdventureReservationService
    ) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadClient();
   }
  loadClient(){
    this.clientService.getById(this.id)
      .subscribe(res => this.client = res)
  }
  Reserve(){
    this.reservation.id=this.adventureFastReservation.id;
    this.reservation.reservationStart=this.adventureFastReservation.reservationStart;
    this.reservation.reservationEnd=this.adventureFastReservation.reservationEnd;
    this.reservation.validityStart=this.adventureFastReservation.validityStart;
    this.reservation.validityEnd=this.adventureFastReservation.validityEnd;
    this.reservation.durationHours=this.adventureFastReservation.durationHours;
    this.reservation.maxPersons=this.adventureFastReservation.maxPersons;
    this.reservation.additionalItems=this.adventureFastReservation.additionalItems;
    this.reservation.client=this.client;
    this.reservation.adventure=this.adventureFastReservation.adventure;
    this.adventureReservationService.reserveAdventureFastReservation(this.reservation)
    .subscribe(res=>this.Reserved.next());

  }

}
