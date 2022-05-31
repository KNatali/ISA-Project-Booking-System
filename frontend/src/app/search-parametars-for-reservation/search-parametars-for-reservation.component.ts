import { Cottage } from './../model/cottage';
import { BoatReservationService } from './../service/boat-reservation.service';
import { BoatReservationCreate } from './../model/boatReservationCreate';
import { BoatReservation } from './../model/boat-reservation';
import { AdditionalItem } from './../model/additionalItem';
import { SearchForReservation } from './../model/searchForReservation';
import { Component, Input, OnInit } from '@angular/core';
import { Boat } from '../model/boat';
import { CottageReservationCreate } from '../model/cottageReservationCreate';
import { isThisSecond } from 'date-fns';
import { CottageReservationService } from '../service/cottage-reservation.service';
import { Adventure } from '../model/adventure';
import { AdventureReservationCreate } from '../model/adventureReservationCreate';
import { AdventureReservationService } from '../service/adventure-reservation.service';

@Component({
  selector: 'app-search-parametars-for-reservation',
  templateUrl: './search-parametars-for-reservation.component.html',
  styleUrls: ['./search-parametars-for-reservation.component.css']
})
export class SearchParametarsForReservationComponent implements OnInit {
  @Input()
  additionalItemPrice:number;
  @Input()
  type:string;
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
  @Input()
  adventure:Adventure;
  @Input()
  cottage:Cottage;
  constructor(private boatReservationService: BoatReservationService,
    private cottageReservationService: CottageReservationService,
    private adventureReservationService: AdventureReservationService
    ) { }
  resBoat:BoatReservationCreate=new BoatReservationCreate({
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
  resCottage:CottageReservationCreate=new CottageReservationCreate({
    id: 0,
    reservationStart: '',
    numberOfDays:0,
    numberOfPersons: 0,
    price: 0,
    additionalItems: [],
    clientId:0,
    cottageId: 0,
    systemEarning: 0,
  })
  resAdventure:AdventureReservationCreate=new AdventureReservationCreate({
    id: 0,
    reservationStart: '',
    numberOfDays:0,
    numberOfPersons: 0,
    price: 0,
    additionalItems: [],
    clientId:0,
    adventureId: 0,
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

    if(this.type=="cottage"){
      this.resCottage.reservationStart=this.search.dateAndTime;
      this.resCottage.numberOfPersons=this.search.numOfPerson;
      this.resCottage.numberOfDays=this.search.numOfDay;
      this.resCottage.price=this.priceOfReservation;
      this.resCottage.cottageId=this.cottage.id;
      this.resCottage.additionalItems.push(this.additionalItem);
      this.resCottage.clientId=this.idClient;
      this.resCottage.additionalItems=this.additionalItems;
      console.log(this.resBoat);
      this.cottageReservationService.addCottageReservationClient(this.resCottage).subscribe();
    }
    if (this.type=="boat"){
      this.resBoat.reservationStart=this.search.dateAndTime;
      this.resBoat.numberOfPersons=this.search.numOfPerson;
      this.resBoat.numberOfDays=this.search.numOfDay;
      this.resBoat.price=this.priceOfReservation;
      this.resBoat.boatId=this.boat.id;
      this.resBoat.additionalItems.push(this.additionalItem);
      this.resBoat.clientId=this.idClient;
      this.resBoat.additionalItems=this.additionalItems;
      console.log(this.resBoat);
      this.boatReservationService.addBoatReservationClient(this.resBoat).subscribe();
    }
    if(this.type=="adventure"){
      this.resAdventure.reservationStart=this.search.dateAndTime;
      this.resAdventure.numberOfPersons=this.search.numOfPerson;
      this.resAdventure.numberOfDays=this.search.numOfDay;
      this.resAdventure.price=this.priceOfReservation;
      this.resAdventure.adventureId=this.adventure.id;
      this.resAdventure.additionalItems.push(this.additionalItem);
      this.resAdventure.clientId=this.idClient;
      this.resAdventure.additionalItems=this.additionalItems;
      console.log(this.resBoat);
      this.adventureReservationService.addAdventureReservationClient(this.resAdventure).subscribe();
    }
    this.showForm=false;
    this.reservationSeccess=true;

  }

}
