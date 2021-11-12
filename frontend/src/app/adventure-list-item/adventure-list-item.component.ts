import { Adventure } from './../model/adventure';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'tr[app-adventure-list-item]',
  templateUrl: './adventure-list-item.component.html',
  styleUrls: ['./adventure-list-item.component.css']
})
export class AdventureListItemComponent implements OnInit {
  @Input()
  adventure: Adventure;

  constructor() { }

  ngOnInit(): void {
  }

}
