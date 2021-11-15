import { Component, Input, OnInit } from '@angular/core';
import { Boat } from '../model/boat';

@Component({
  selector: 'app-boat-list-item',
  templateUrl: './boat-list-item.component.html',
  styleUrls: ['./boat-list-item.component.css']
})
export class BoatListItemComponent implements OnInit {
  @Input()
  boat:Boat;

  constructor() { }

  ngOnInit(): void {
  }

}
