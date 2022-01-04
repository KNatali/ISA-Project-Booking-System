import { AdventureFastReservation } from './../model/adventureFastReservation';
import { AdditionalItem } from './../model/additionalItem';
import { AdventureBehavioralRules, AdventureBehavioralRulesInterface } from './../model/adventureBehavioralRules';
import { AdventureFishingEquipment } from './../model/adventureFishingEquipment';
import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { HttpClient } from '@angular/common/http';
import { Loader } from '@googlemaps/js-api-loader';

@Component({
  selector: 'app-instructor-adventure-profile',
  templateUrl: './instructor-adventure-profile.component.html',
  styleUrls: ['./instructor-adventure-profile.component.css']
})
export class InstructorAdventureProfileComponent implements OnInit {
  map: any;
  loader: any;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  cancellation: any;
  id: number;
  adventure: Adventure;
  currentRate = 8;
  actions: AdventureFastReservation[];

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.loader = new Loader({
      apiKey: 'AIzaSyAHO2M3hFpxZPCjEBmoWnaetSWNC8DHOKI'
    })
    this.loadData();
    this.loadEquipment();
    this.loadBehavioralRules();
    this.loadAdditionalItems();
    this.loadActions();


  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventure(this.id)
        .subscribe((adventure: Adventure) => {
          this.adventure = adventure;

          if (this.adventure.mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.adventure.mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.adventure.mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
          this.loader.load().then(() => {
            this.map = new google.maps.Map(document.getElementById("map")!, {
              center: { lat: this.adventure.address.latitude, lng: this.adventure.address.longitude },
              zoom: 11.5
            })
          })

        });

    });


  }
  loadEquipment() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureEquipment(this.id)
        .subscribe((equipment: AdventureFishingEquipment[]) => this.adventure.equipment = equipment);
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureBehavioralRules(this.id)
        .subscribe((rules: AdventureBehavioralRules[]) => this.adventure.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => this.adventure.additionalItems = items);
    });
  }

  loadActions() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureFastReservations(this.id)
        .subscribe((items: AdventureFastReservation[]) => this.actions = items);
    });
  }

  edit() {
    this.router.navigate(['instructor/adventures/edit/:id'])
  }



}
