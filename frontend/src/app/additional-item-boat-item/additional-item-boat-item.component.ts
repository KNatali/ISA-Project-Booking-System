import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AdditionalItem, AdditionalItemInterface } from '../model/additionalItem';

@Component({
  selector: 'tr[app-additional-item-boat-item]',
  templateUrl: './additional-item-boat-item.component.html',
  styleUrls: ['./additional-item-boat-item.component.css']
})
export class AdditionalItemBoatItemComponent implements OnInit {
  @Input()
  addItem:AdditionalItem;
  @Output()
  addedOneAdditioanlItem:EventEmitter<AdditionalItem>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  AddAditionalItem(){
    console.log(this.addItem);
    this.addedOneAdditioanlItem.next(this.addItem);
  }
}
