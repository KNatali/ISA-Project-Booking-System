import { SearchForReservation } from './../model/searchForReservation';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-reservation-search-form',
  templateUrl: './reservation-search-form.component.html',
  styleUrls: ['./reservation-search-form.component.css']
})
export class ReservationSearchFormComponent implements OnInit {

  search:SearchForReservation=new SearchForReservation({
    id: 0,
    dateAndTime:'',
    numOfDay:0,
    numOfPerson:0
  })
  @Input()
  type:string;
  @Output()
  formIsFill:EventEmitter<SearchForReservation>=new EventEmitter();
  @Output()
  formIsFillCottage:EventEmitter<SearchForReservation>=new EventEmitter();


  @Output()
  sortByPriceAvailable:EventEmitter<void>=new EventEmitter();
  @Output()
  sortByGradeAvailable:EventEmitter<void>=new EventEmitter();

  constructor(private boatService: BoatService) {
    this.search.dateAndTime = new Date().toISOString().slice(0, 16);
  }

  ngOnInit(): void {
  }
  Search1(){
    if (this.type=="cottage"){
      this.formIsFillCottage.next(this.search);
    }
    if(this.type=="boat"){
      this.formIsFill.next(this.search);
    }

  }
  sortByPriceAvailableBoat(){
    this.sortByPriceAvailable.next();
  }
  sortByGradeAvailableBoat(){
    this.sortByGradeAvailable.next();
  }
}
