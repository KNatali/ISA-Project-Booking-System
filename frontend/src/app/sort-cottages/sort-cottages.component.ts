import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-sort-cottages',
  templateUrl: './sort-cottages.component.html',
  styleUrls: ['./sort-cottages.component.css']
})
export class SortCottagesComponent implements OnInit {
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
