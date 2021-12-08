import { AdventureService } from './../service/adventure.service';
import { BoatService } from './../service/boat.service';
import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { Boat } from '../model/boat';
import { Cottage } from '../model/cottage';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-admin-entities',
  templateUrl: './admin-entities.component.html',
  styleUrls: ['./admin-entities.component.css']
})
export class AdminEntitiesComponent implements OnInit {
  boatShow: boolean = false;
  cottageShow: boolean = false;
  adventureShow: boolean = false;
  adventures: Adventure[];
  boats: Boat[];
  cottages: Cottage[];
  constructor(private cottageService: CottageService, private boatService: BoatService, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.getCottages();
    this.getBoats();
    this.getAdvetures();
  }

  getCottages() {
    this.cottageService.getCottages()
      .subscribe(res => this.cottages = res)
  }

  getBoats() {
    this.boatService.getBoats()
      .subscribe(res => this.boats = res)
  }


  getAdvetures() {
    this.adventureService.getAdventures()
      .subscribe(res => this.adventures = res)
  }
  deleteCottage(id: any) {

  }
  deleteBoat(id: any) {

  }
  deleteAdventure(id: any) {
    this.adventureService.deleteAdventure(id)
      .subscribe();
  }

  showCottages() {
    this.cottageShow = true;
    this.boatShow = false;
    this.adventureShow = false;
  }
  showBoats() {
    this.cottageShow = false;
    this.boatShow = true;
    this.adventureShow = false;
  }
  showAdventures() {
    this.cottageShow = false;
    this.boatShow = false;
    this.adventureShow = true;
  }

}
