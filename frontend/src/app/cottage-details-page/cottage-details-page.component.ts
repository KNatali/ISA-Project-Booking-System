import { Component, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage1';
import { ActivatedRoute, Router } from '@angular/router';
import { CottageOwner } from '../model/cottageOwner';
import { Cottage1Service } from '../service/cottage1.service';
import { AdditionalItem } from '../model/additionalItem';
import { UnsubscribedItem } from '../model/unsubscribedItem';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-cottage-details-page',
  templateUrl: './cottage-details-page.component.html',
  styleUrls: ['./cottage-details-page.component.css']
})
export class CottageDetailsPageComponent implements OnInit {
  id: number;
  additionalItem:AdditionalItem=new AdditionalItem({
    name:'',
    price:0,
    id:0
  });
  type:string="cottage";
  price:number=0;
  cottage:Cottage;/*=new Cottage({
    id:0,
    name:'',
    state:'',
    street:'',
    city:'',
    description:'',
    grade:0,
    mainPicture:''
  });*/
  clientId:any;
  subscribedItem:UnsubscribedItem=new UnsubscribedItem({
    clientIt:0,
    entityId:0
  });
  role:any;
  visiable_sort_button:boolean;
  additionalItems:AdditionalItem[]=[];

  constructor(private route: ActivatedRoute,private cottageService: CottageService,private router: Router) { }

  ngOnInit(): void {
    this.clientId = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottage(this.id)
        .subscribe((cottage: Cottage) => this.cottage = cottage);
    });
    this.role=sessionStorage.getItem('role');
    if(this.role=='Client'){
      this.visiable_sort_button=true;
    }else{
      this.visiable_sort_button=false;
    }
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
    this.cottageService.subscribe(this.subscribedItem)
    .subscribe()
    this.router.navigate(['clients', this.clientId]);
  }

}
