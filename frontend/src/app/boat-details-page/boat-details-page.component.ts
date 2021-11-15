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
  boat:Boat;

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
