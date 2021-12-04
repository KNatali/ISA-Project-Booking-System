import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-sort-boats',
  templateUrl: './sort-boats.component.html',
  styleUrls: ['./sort-boats.component.css']
})
export class SortBoatsComponent implements OnInit {

  constructor(private boatService: BoatService) { }
  @Output()
  SortedByName:EventEmitter<void>=new EventEmitter();
  @Output()
  SortedByGrade:EventEmitter<void>=new EventEmitter();

  ngOnInit(): void {
  }
  sortByName(){
    this.SortedByName.next();
  }
  sortByStreet(){}
  sortByGrade(){
    this.SortedByGrade.next();
  }

}
