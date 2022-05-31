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
  formIsFillAdventure:EventEmitter<SearchForReservation>=new EventEmitter();


  @Output()
  sortByPriceAvailable:EventEmitter<void>=new EventEmitter();
  @Output()
  sortByGradeAvailable:EventEmitter<void>=new EventEmitter();
  @Output()
  sortByPriceAvailableCottage:EventEmitter<void>=new EventEmitter();
  @Output()
  sortByGradeAvailableCottage:EventEmitter<void>=new EventEmitter();
  @Output()
  sortByPriceAvailableAdventure:EventEmitter<void>=new EventEmitter();
  @Output()
  sortByGradeAvailableAdventure:EventEmitter<void>=new EventEmitter();

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
    if(this.type=="adventure"){
      this.formIsFillAdventure.next(this.search);
    }

  }
  sortByPriceAvailableBoat(){
    if (this.type=="cottage"){
      this.sortByPriceAvailableCottage.next();
    }
    if(this.type=="boat"){
      this.sortByPriceAvailable.next();
    }
    if(this.type=="adventure"){
      this.sortByPriceAvailableAdventure.next();
    }
  }
  sortByGradeAvailableBoat(){
    if (this.type=="cottage"){
      this.sortByGradeAvailableCottage.next();
    }
    if(this.type=="boat"){
      this.sortByGradeAvailable.next();
    }
    if(this.type=="adventure"){
      this.sortByGradeAvailableAdventure.next();
    }
  }
}
