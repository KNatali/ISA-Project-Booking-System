import { AdditionalItem } from './../model/additionalItem';
import { SearchForReservation } from './../model/searchForReservation';
import { Component, Input, OnInit } from '@angular/core';

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
  price:number=0;
  priceOfReservation:number=0;
  search:SearchForReservation=new SearchForReservation({
    id: 0,
    dateAndTime:'',
    numOfDay:0,
    numOfPerson:0
  })
  @Input()
  additionalItem:AdditionalItem;
  constructor() { }

  ngOnInit(): void {
  }
  CalculatePrice(){
    console.log(this.additionalItemPrice);
    console.log(this.search.numOfPerson);
    console.log(this.boatPrice);
    this.priceOfReservation=this.additionalItemPrice+this.search.numOfPerson*this.boatPrice*this.search.numOfDay;
    alert(this.priceOfReservation);
  }
  Reservate(){}

}
