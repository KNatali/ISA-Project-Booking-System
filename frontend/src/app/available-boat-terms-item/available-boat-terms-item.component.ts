import { Component, OnInit, Input } from '@angular/core';
import { AvailableTerm } from '../model/availableBoatTerm';

@Component({
  selector: 'tr[app-available-boat-terms-item]',
  templateUrl: './available-boat-terms-item.component.html',
  styleUrls: ['./available-boat-terms-item.component.css']
})
export class AvailableBoatTermsItemComponent implements OnInit {
  @Input()
  term: AvailableTerm;
  constructor() { }

  ngOnInit(): void {
  }

}
