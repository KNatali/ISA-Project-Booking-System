import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Adventure } from '../model/adventure';
import { UnsubscribedItem } from '../model/unsubscribedItem';
import { AdventureService } from '../service/adventure.service';

@Component({
  selector: 'app-subscribed-adventure-list',
  templateUrl: './subscribed-adventure-list.component.html',
  styleUrls: ['./subscribed-adventure-list.component.css']
})
export class SubscribedAdventureListComponent implements OnInit {
  adventures:Adventure[]=[];
  id:any;
  unsubscribedItem:UnsubscribedItem=new UnsubscribedItem({
    clientIt:0,
    entityId:0
  });
  constructor(private adventureService:AdventureService ,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getSubscribedAdventures(this.id)
      .subscribe(res=>this.adventures=res)
    });
  }
  unsubsrcibe(advId:number){
    //treba napraviti objekat koji ce imati id klijenta i id broda
        this.unsubscribedItem.clientIt=this.id;
        this.unsubscribedItem.entityId=advId;
        this.adventureService.unsubscribe(this.unsubscribedItem)
        .subscribe(res=>this.loadData())
      }

}
