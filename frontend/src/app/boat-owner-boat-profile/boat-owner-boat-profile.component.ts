import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { AdditionalItem } from '../model/additionalItem';
import { Boat } from '../model/boat';
import { BoatBehavioralRules } from '../model/boatBehavioralRules';
import { BoatFastReservation } from '../model/boatFastReservation';
import { BoatRevision } from '../model/boatRevision';
import { NavigationEquipment } from '../model/navigationEquipment';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-owner-boat-profile',
  templateUrl: './boat-owner-boat-profile.component.html',
  styleUrls: ['./boat-owner-boat-profile.component.css']
})
export class BoatOwnerBoatProfileComponent implements OnInit {
  map: any;
  loader: any;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  cancellation: any;
  id: number;
  boat: Boat;
  currentRate = 8;
  actions: BoatFastReservation[];
  revisions: BoatRevision[];
  constructor(private http: HttpClient,private route: ActivatedRoute, private router: Router, private boatService: BoatService) { }

  ngOnInit(): void {
    this.loader = new Loader({
      apiKey: 'AIzaSyCzQcuipLCfmTv54GORP3ha_uvWAF-QUdE'
    })
    this.loadData();
    this.loadBehavioralRules();
    this.loadAdditionalItems();
    this.loadNavigationEquipment();
    this.loadActions();
    this.loadRevisions();
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBoat(this.id)
        .subscribe((boat: Boat) => 
        {
          this.boat = boat;
          if (this.boat.mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.boat.mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.boat.mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
          this.loader.load().then(() => {
            this.map = new google.maps.Map(document.getElementById("map")!, {
              center: { lat: this.boat.address.latitude, lng: this.boat.address.longitude },
              zoom: 11.5
            })
          })
        });
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBehavioralRules(this.id)
        .subscribe((rules: BoatBehavioralRules[]) => this.boat.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => 
        {
        this.boat.additionalItems = items});
    });
  }

  loadNavigationEquipment() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getNavigationEquipment(this.id)
        .subscribe((equipment: NavigationEquipment[]) => this.boat.equipment = equipment);
    });
  }

  loadActions() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBoatFastReservations(this.id)
        .subscribe((items: BoatFastReservation[]) => this.actions = items);
    });
  }

  loadRevisions() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getAllBoatRevisionsByBoat(this.id)
        .subscribe((items: BoatRevision[]) => this.revisions = items);
    });
  }
  edit() {
    this.router.navigate(['boatOwner/boats/edit/:id'])
  }

}
