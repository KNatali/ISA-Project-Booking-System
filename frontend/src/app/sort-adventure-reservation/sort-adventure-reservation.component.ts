import { Component, OnInit , Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-sort-adventure-reservation',
  templateUrl: './sort-adventure-reservation.component.html',
  styleUrls: ['./sort-adventure-reservation.component.css']
})
export class SortAdventureReservationComponent implements OnInit {
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
