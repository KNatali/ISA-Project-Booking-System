import { Component, OnInit, Output,EventEmitter, ContentChild } from '@angular/core';

@Component({
  selector: 'app-search-adventure',
  templateUrl: './search-adventure.component.html',
  styleUrls: ['./search-adventure.component.css']
})
export class SearchAdventureComponent implements OnInit {
  firstAndLastName:string;
  @Output()
  //AddedInstructor: EventEmitter<({firstName:string,lastName:string})>=new EventEmitter();
  AddedInstructor: EventEmitter<string>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  findByInstructorFirstAndLastName(){
    this.AddedInstructor.next(this.firstAndLastName);
  }
}
