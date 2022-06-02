import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-search-available-entitis',
  templateUrl: './search-available-entitis.component.html',
  styleUrls: ['./search-available-entitis.component.css']
})
export class SearchAvailableEntitisComponent implements OnInit {
  @Input()
  type:string;
  @Output()
  startFindByGradeAvailableAdventure:EventEmitter<number>=new EventEmitter();
  find_by_grade:number;
  @Output()
  startFindByPriceAvailableAdventure:EventEmitter<number>=new EventEmitter();
  @Output()
  startFindByGradeAvailableCottage:EventEmitter<number>=new EventEmitter();
  @Output()
  startFindByPriceAvailableCottage:EventEmitter<number>=new EventEmitter();
  @Output()
  startFindByGradeAvailableBoat:EventEmitter<number>=new EventEmitter();
  @Output()
  startFindByPriceAvailableBoat:EventEmitter<number>=new EventEmitter();
  find_by_price:number;
  constructor() { }

  ngOnInit(): void {
  }
  findByGradeAvailable(){
    if (this.type=="adventure"){
      this.startFindByGradeAvailableAdventure.next(this.find_by_grade);
    }
    if (this.type=="cottage"){
      this.startFindByGradeAvailableCottage.next(this.find_by_grade);
    }
    if (this.type=="boat"){
      this.startFindByGradeAvailableBoat.next(this.find_by_grade);
    }
  }
  findByPriceAvailable(){
    if (this.type=="adventure"){
      this.startFindByPriceAvailableAdventure.next(this.find_by_price);
    }
    if (this.type=="cottage"){
      this.startFindByPriceAvailableCottage.next(this.find_by_price);
    }
    if (this.type=="boat"){
      this.startFindByPriceAvailableBoat.next(this.find_by_price);
    }
  }
}
