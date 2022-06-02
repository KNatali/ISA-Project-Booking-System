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
  constructor() { }

  ngOnInit(): void {
  }
  findByGradeAvailable(){
    if (this.type=="adventure"){
      this.startFindByGradeAvailableAdventure.next(this.find_by_grade);
  }
}
}
