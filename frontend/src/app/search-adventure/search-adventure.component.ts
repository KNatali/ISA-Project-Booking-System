import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-adventure',
  templateUrl: './search-adventure.component.html',
  styleUrls: ['./search-adventure.component.css']
})
export class SearchAdventureComponent implements OnInit {
  firstName:string;
  lastName:string;

  constructor() { }

  ngOnInit(): void {
  }
  findByInstructorFirstAndLastName(){}
}
