import { Component, OnInit, Input } from '@angular/core';
import { AvailableTerm } from '../model/availableBoatTerm';

@Component({
  selector: 'app-available-boat-terms-list',
  templateUrl: './available-boat-terms-list.component.html',
  styleUrls: ['./available-boat-terms-list.component.css']
})
export class AvailableBoatTermsListComponent implements OnInit {
  terms:AvailableTerm[];
  term1:AvailableTerm=new AvailableTerm({
    start:new Date("2022-01-16"),
    end:new Date("2022-01-21")
  })
  term2:AvailableTerm=new AvailableTerm({
    start:new Date("2023-01-16"),
    end:new Date("2023-01-21")
  })
  term3:AvailableTerm=new AvailableTerm({
    start:new Date("2022-10-16"),
    end:new Date("2022-10-21")
  })
  constructor() { 
    this.terms=[];
  }

  ngOnInit(): void {
    this.loadData()
  }
  loadData(){
    this.terms.push(this.term1);
    this.terms.push(this.term2);
    this.terms.push(this.term3);
  }

}
