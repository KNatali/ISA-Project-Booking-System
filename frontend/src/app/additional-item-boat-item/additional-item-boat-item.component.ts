import { Component, OnInit , Input} from '@angular/core';
import { AdditionalItem, AdditionalItemInterface } from '../model/additionalItem';

@Component({
  selector: 'tr[app-additional-item-boat-item]',
  templateUrl: './additional-item-boat-item.component.html',
  styleUrls: ['./additional-item-boat-item.component.css']
})
export class AdditionalItemBoatItemComponent implements OnInit {
  @Input()
  addItem:AdditionalItem;
  constructor() { }

  ngOnInit(): void {
  }

}
