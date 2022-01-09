import { Component, OnInit } from '@angular/core';
import { Boat } from '../model/boat';

import { ActivatedRoute } from '@angular/router';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-details-page',
  templateUrl: './boat-details-page.component.html',
  styleUrls: ['./boat-details-page.component.css']
})
export class BoatDetailsPageComponent implements OnInit {
  id: number;
  boat:Boat;/*=new Boat({
    id: 0,
    name: '',
    length: 0,
    motorNumber: 0,
    motorPower: 0,
    maxSpeed: 0,
    description: '',
    capacity: 0,
    grade: 0,
    mainPicture:'',
    state:'',
    street:'',
    city:'',
    address
  });*/

  constructor(private route: ActivatedRoute,private boatService: BoatService) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBoat(this.id)
        .subscribe((boat: Boat) => this.boat = boat);
    });
  }

}
