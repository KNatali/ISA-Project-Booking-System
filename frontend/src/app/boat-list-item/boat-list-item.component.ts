import { Component, Input, OnInit, Output } from '@angular/core';
import { Boat } from '../model/boat';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-list-item',
  templateUrl: './boat-list-item.component.html',
  styleUrls: ['./boat-list-item.component.css']
})
export class BoatListItemComponent implements OnInit {
  @Input()
  boats:Boat[];

  constructor() { }

  ngOnInit(): void {
  }
  

}
