import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { AdditionalItem } from '../model/additionalItem';
import { Cottage } from '../model/cottage1';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageRevision } from '../model/cottageRevision';
import { Cottage1Service } from '../service/cottage1.service';

@Component({
  selector: 'app-cottage-owner-cottage-profile',
  templateUrl: './cottage-owner-cottage-profile.component.html',
  styleUrls: ['./cottage-owner-cottage-profile.component.css']
})
export class CottageOwnerCottageProfileComponent implements OnInit {
  map: any;
  loader: any;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  cancellation: any;
  id: number;
  cottage1: Cottage;
  currentRate = 8;
  actions: CottageFastReservation[];
  revisions: CottageRevision[];

  constructor(private http: HttpClient,private route: ActivatedRoute, private router: Router, private cottageService: Cottage1Service) { }

  ngOnInit(): void {
    this.loader = new Loader({
      apiKey: 'AIzaSyCzQcuipLCfmTv54GORP3ha_uvWAF-QUdE'
    })
    this.loadData();
    this.loadBehavioralRules();
    this.loadAdditionalItems();
    this.loadActions();
    this.loadRevisions();
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottage(this.id)
        .subscribe((cottage1: Cottage) => 
        {
          this.cottage1 = cottage1;
          if (this.cottage1.mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.cottage1.mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.cottage1.mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
          this.loader.load().then(() => {
            this.map = new google.maps.Map(document.getElementById("map")!, {
              center: { lat: this.cottage1.address.latitude, lng: this.cottage1.address.longitude },
              zoom: 11.5
            })
          })

        });
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageBehavioralRules(this.id)
        .subscribe((rules: CottageBehavioralRules[]) => this.cottage1.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => this.cottage1.items = items);
    });
  }

  loadActions() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageFastReservations(this.id)
        .subscribe((items: CottageFastReservation[]) => this.actions = items);
    });
  }
  loadRevisions() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getAllCottageRevisionsByCottage(this.id)
        .subscribe((items: CottageRevision[]) => this.revisions = items);
    });
  }

  edit() {
    this.router.navigate(['cottageOwner/cottages/edit/:id'])
  }

}
