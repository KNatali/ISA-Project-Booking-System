import { BoatReservationService } from './../service/boat-reservation.service';
import { BoatReservationCreate } from './../model/boatReservationCreate';
import { BoatReservation } from './../model/boat-reservation';
import { AdditionalItem } from './../model/additionalItem';
import { SearchForReservation } from './../model/searchForReservation';
import { Component, Input, OnInit } from '@angular/core';
import { Boat } from '../model/boat';

@Component({
  selector: 'app-search-parametars-for-reservation',
  templateUrl: './search-parametars-for-reservation.component.html',
  styleUrls: ['./search-parametars-for-reservation.component.css']
})
export class SearchParametarsForReservationComponent implements OnInit {
  @Input()
  additionalItemPrice:number;
  @Input()
  boatPrice:number;
  @Input()
  additionalItems:AdditionalItem[];
  reservationSeccess:boolean=false;
  showForm:boolean=true;
  price:number=0;
  idClient:any;
  priceOfReservation:number=0;
  search:SearchForReservation=new SearchForReservation({
    id: 0,
    dateAndTime:'',
    numOfDay:0,
    numOfPerson:0
  })
  @Input()
  additionalItem:AdditionalItem;
  @Input()
  boat :Boat;
  constructor(private boatReservationService: BoatReservationService) { }
  res:BoatReservationCreate=new BoatReservationCreate({
    id: 0,
    reservationStart: '',
    numberOfDays:0,
    numberOfPersons: 0,
    price: 0,
    additionalItems: [],
    clientId:0,
    boatId: 0,
    systemEarning: 0,
  })
  ngOnInit(): void {
    this.idClient = sessionStorage.getItem('id');
  }
  CalculatePrice(){
    //console.log(this.additionalItemPrice);
    //console.log(this.search.numOfPerson);
    //console.log(this.boatPrice);
    this.priceOfReservation=this.additionalItemPrice+this.search.numOfPerson*this.boatPrice*this.search.numOfDay;
    alert(this.priceOfReservation);
    //console.log(this.boat);
  }
  Reservate(){
    this.res.reservationStart=this.search.dateAndTime;
    this.res.numberOfPersons=this.search.numOfPerson;
    this.res.numberOfDays=this.search.numOfDay;
    this.res.price=this.priceOfReservation;
    this.res.boatId=this.boat.id;
    this.res.additionalItems.push(this.additionalItem);
    this.res.clientId=this.idClient;
    this.res.additionalItems=this.additionalItems;
    console.log(this.res);
    this.boatReservationService.addBoatReservationClient(this.res).subscribe();
    this.showForm=false;
    this.reservationSeccess=true;

  }

}
