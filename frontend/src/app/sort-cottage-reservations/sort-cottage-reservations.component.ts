import { Component, OnInit ,EventEmitter,Output} from '@angular/core';

@Component({
  selector: 'app-sort-cottage-reservations',
  templateUrl: './sort-cottage-reservations.component.html',
  styleUrls: ['./sort-cottage-reservations.component.css']
})
export class SortCottageReservationsComponent implements OnInit {
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
