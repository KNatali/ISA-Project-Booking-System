import { Component, Input, OnInit } from '@angular/core';
import { Boat } from '../model/boat';

@Component({
  selector: 'tr[app-boat-item]',
  templateUrl: './boat-item.component.html',
  styleUrls: ['./boat-item.component.css']
})
export class BoatItemComponent implements OnInit {
  @Input()
  boat:Boat;
  constructor() { }

  ngOnInit(): void {
  }

}
