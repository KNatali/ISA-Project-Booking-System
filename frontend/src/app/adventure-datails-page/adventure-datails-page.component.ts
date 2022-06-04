import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { AdditionalItem } from '../model/additionalItem';
import { UnsubscribedItem } from '../model/unsubscribedItem';

@Component({
  selector: 'app-adventure-datails-page',
  templateUrl: './adventure-datails-page.component.html',
  styleUrls: ['./adventure-datails-page.component.css']
})
export class AdventureDatailsPageComponent implements OnInit {
  id: number;
  additionalItems:AdditionalItem[]=[];
  price:number=0;
  adventure: Adventure;
  type:string="adventure";
  additionalItem:AdditionalItem=new AdditionalItem({
    name:'',
    price:0,
    id:0
  });
  clientId:any;
  constructor(private route: ActivatedRoute,private adventureService:AdventureService,private router: Router) { }

  ngOnInit(): void {
    this.clientId = sessionStorage.getItem('id');
    this.loadData();
  }
  subscribedItem:UnsubscribedItem=new UnsubscribedItem({
    clientIt:0,
    entityId:0
  });
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventure(this.id)
        .subscribe((adventure: Adventure) => this.adventure = adventure);
    });
  }
  addAdditionalItem(item:AdditionalItem){
    this.additionalItem=item;
    this.additionalItems.push(item);
    //this.addedOneAdditioanlItem.next(item);
    this.price=this.price+item.price;
    console.log("boat details",this.price);
  }
  subscribe(){
    this.subscribedItem.clientIt=this.clientId;
    this.subscribedItem.entityId=this.id;
    this.adventureService.subscribe(this.subscribedItem)
    .subscribe()
    this.router.navigate(['clients', this.clientId]);
  }

}
