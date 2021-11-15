import { Component, Input, OnInit } from '@angular/core';
import { Boat } from '../model/boat';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-list-item',
  templateUrl: './boat-list-item.component.html',
  styleUrls: ['./boat-list-item.component.css']
})
export class BoatListItemComponent implements OnInit {
  boats:Boat[];

  constructor(private boatService:BoatService) { }

  ngOnInit(): void {
    this.getBoats();
  }
  getBoats(){
    this.boatService.getBoats()
    .subscribe(res=>this.boats=res)
  }

}
