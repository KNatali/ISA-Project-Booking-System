import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Boat } from '../model/boat';
import { UnsubscribedItem } from '../model/unsubscribedItem';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-subscribed-boat-list',
  templateUrl: './subscribed-boat-list.component.html',
  styleUrls: ['./subscribed-boat-list.component.css']
})
export class SubscribedBoatListComponent implements OnInit {
  boats:Boat[]=[];
  id:any;
  unsubscribedItem:UnsubscribedItem=new UnsubscribedItem({
    clientIt:0,
    entityId:0
  });
  constructor(private boatService:BoatService ,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getSubscribedBoats(this.id)
      .subscribe(res=>this.boats=res)
    });
  }
  unsubsrcibe(boatId:number){
//treba napraviti objekat koji ce imati id klijenta i id broda
    this.unsubscribedItem.clientIt=this.id;
    this.unsubscribedItem.entityId=boatId;
    this.boatService.unsubscribe(this.unsubscribedItem)
    .subscribe(res=>this.loadData())
  }
}
