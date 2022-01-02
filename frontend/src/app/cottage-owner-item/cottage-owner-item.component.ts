import { Component, Input, OnInit } from '@angular/core';
import { CottageOwner } from '../model/cottageOwner';

@Component({
  selector: 'app-cottage-owner-item',
  templateUrl: './cottage-owner-item.component.html',
  styleUrls: ['./cottage-owner-item.component.css']
})
export class CottageOwnerItemComponent implements OnInit {
  @Input()
  owner:CottageOwner;
  constructor() { }

  ngOnInit(): void {
    console.log(this.owner)
  }
  seeCottages() {}

}
