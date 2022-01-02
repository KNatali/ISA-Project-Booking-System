import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-sort-owners',
  templateUrl: './sort-owners.component.html',
  styleUrls: ['./sort-owners.component.css']
})
export class SortOwnersComponent implements OnInit {
  @Output()
  SortedByName:EventEmitter<void>=new EventEmitter();
  @Output()
  SortedByGrade:EventEmitter<void>=new EventEmitter();
  @Output()
  SortedByCity:EventEmitter<void>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  sortByName(){
    this.SortedByName.next();
  }
  sortByCity(){
    this.SortedByCity.next();
  }
  sortByGrade(){
    this.SortedByGrade.next();
  }
}
