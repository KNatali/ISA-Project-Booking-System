import { Component, OnInit } from '@angular/core';
import { AdditionalItem, AdditionalItemInterface } from '../model/additionalItem';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-additional-item-boat-list',
  templateUrl: './additional-item-boat-list.component.html',
  styleUrls: ['./additional-item-boat-list.component.css']
})
export class AdditionalItemBoatListComponent implements OnInit {
  items:AdditionalItem[];
  constructor(private boatService: BoatService) { 
    this.items=[];
  }

  ngOnInit(): void {
    this.loadData();
  }
  loadData(){
    this.boatService.findAllAdditionalItems()
    .subscribe(res=>this.items=res)
  }

}
