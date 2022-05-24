import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdditionalItem, AdditionalItemInterface } from '../model/additionalItem';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-additional-item-boat-list',
  templateUrl: './additional-item-boat-list.component.html',
  styleUrls: ['./additional-item-boat-list.component.css']
})
export class AdditionalItemBoatListComponent implements OnInit {
  items:AdditionalItem[];
  id:number;
  constructor(private boatService: BoatService,private route: ActivatedRoute) {
    this.items=[];
  }

  ngOnInit(): void {
    //this.loadData();
    this.loadAdditionalItems();
  }
  loadData(){
    this.boatService.findAllAdditionalItems()
    .subscribe(res=>this.items=res)
  }
  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) =>
        {
        this.items = items
        //alert(this.boat.additionalItems.length)
      });
    });
  }

}
