import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cottage } from '../model/cottage';
import { UnsubscribedItem } from '../model/unsubscribedItem';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-subscribed-cottage-list',
  templateUrl: './subscribed-cottage-list.component.html',
  styleUrls: ['./subscribed-cottage-list.component.css']
})
export class SubscribedCottageListComponent implements OnInit {
  cottages:Cottage[]=[];
  id:any;
  unsubscribedItem:UnsubscribedItem=new UnsubscribedItem({
    clientIt:0,
    entityId:0
  });
  constructor(private cottageService:CottageService ,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getSubscribedCottages(this.id)
      .subscribe(res=>this.cottages=res)
    });
  }

  unsubsrcibe(cottageId:number){
    //treba napraviti objekat koji ce imati id klijenta i id broda
        this.unsubscribedItem.clientIt=this.id;
        this.unsubscribedItem.entityId=cottageId;
        this.cottageService.unsubscribe(this.unsubscribedItem)
        .subscribe(res=>this.loadData())
      }
}
