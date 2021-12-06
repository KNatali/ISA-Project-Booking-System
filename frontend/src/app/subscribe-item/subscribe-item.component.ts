import { Component, Input, OnInit } from '@angular/core';
import { Item } from '../model/item';

@Component({
  selector: 'tr[app-subscribe-item]',
  templateUrl: './subscribe-item.component.html',
  styleUrls: ['./subscribe-item.component.css']
})
export class SubscribeItemComponent implements OnInit {
  @Input()
  item:Item;
  constructor() { }

  ngOnInit(): void {
  }

}
