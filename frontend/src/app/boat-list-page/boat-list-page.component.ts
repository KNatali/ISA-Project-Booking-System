import { Component, OnInit } from '@angular/core';
import { BoatService } from '../boat.service';
import { Boat } from '../model/boat';

@Component({
  selector: 'app-boat-list-page',
  templateUrl: './boat-list-page.component.html',
  styleUrls: ['./boat-list-page.component.css']
})
export class BoatListPageComponent implements OnInit {

  boats:Boat[];

  constructor(private boatService:BoatService) {
    this.boats=[];
   }

  ngOnInit(): void {
    this.getBoats();
  }

  getBoats(){
    this.boatService.getBoats()
    .subscribe(res=>this.boats=res)
  }

}
