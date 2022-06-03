import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Boat } from '../model/boat';

@Component({
  selector: 'tr[app-boat-item]',
  templateUrl: './boat-item.component.html',
  styleUrls: ['./boat-item.component.css']
})
export class BoatItemComponent implements OnInit {
  @Input()
  boat:Boat;
  @Output()
  Unsubsrcibed:EventEmitter<number>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  Unsubscribe(){
    this.Unsubsrcibed.next(this.boat.id);
  }

}
