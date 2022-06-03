import { Adventure } from './../model/adventure';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'tr[app-adventure-list-item]',
  templateUrl: './adventure-list-item.component.html',
  styleUrls: ['./adventure-list-item.component.css']
})
export class AdventureListItemComponent implements OnInit {
  @Input()
  adventure: Adventure;
  @Output()
  Unsubsrcibed:EventEmitter<number>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  Unsubscribe(){
    this.Unsubsrcibed.next(this.adventure.id);
  }
}
