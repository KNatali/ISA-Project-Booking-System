import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-sort-boat-reservations',
  templateUrl: './sort-boat-reservations.component.html',
  styleUrls: ['./sort-boat-reservations.component.css']
})
export class SortBoatReservationsComponent implements OnInit {
  @Output()
  SortedByPrice:EventEmitter<void>=new EventEmitter();
  @Output()
  SortedByDuration:EventEmitter<void>=new EventEmitter();
  @Output()
  SortedByDate:EventEmitter<void>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  sortByPrice(){
    this.SortedByPrice.next();
  }
  sortByDuration(){
    this.SortedByDuration.next();
  }
  sortByDate(){
    this.SortedByDate.next();
  }

}
