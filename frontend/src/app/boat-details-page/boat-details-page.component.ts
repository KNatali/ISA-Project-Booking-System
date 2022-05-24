import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Boat } from '../model/boat';

import { ActivatedRoute } from '@angular/router';
import { BoatService } from '../service/boat.service';
import { AdditionalItem } from '../model/additionalItem';

@Component({
  selector: 'app-boat-details-page',
  templateUrl: './boat-details-page.component.html',
  styleUrls: ['./boat-details-page.component.css']
})
export class BoatDetailsPageComponent implements OnInit {
  id: number;
  additionalItem:AdditionalItem=new AdditionalItem({
    name:'',
    price:0,
    id:0
  });
  price:number=0;
  @Output()
  addedOneAdditioanlItem:EventEmitter<AdditionalItem>=new EventEmitter();
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
    this.loadAdditionalItems();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBoat(this.id)
        .subscribe((boat: Boat) => this.boat = boat);
    });
  }
  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) =>
        {
        this.boat.additionalItems = items
        //alert(this.boat.additionalItems.length)
      });
    });
  }
  addAdditionalItem(item:AdditionalItem){
    this.additionalItem=item;
    //this.addedOneAdditioanlItem.next(item);
    this.price=this.price+item.price;
    console.log("boat details",this.price);
  }
}
