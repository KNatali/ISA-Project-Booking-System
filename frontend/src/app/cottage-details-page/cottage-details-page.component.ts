import { Component, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage1';
import { ActivatedRoute } from '@angular/router';
import { CottageOwner } from '../model/cottageOwner';
import { Cottage1Service } from '../service/cottage1.service';
import { AdditionalItem } from '../model/additionalItem';

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
  additionalItems:AdditionalItem[]=[];

  constructor(private route: ActivatedRoute,private cottageService: Cottage1Service) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottage(this.id)
        .subscribe((cottage: Cottage) => this.cottage = cottage);
    });
  }
  addAdditionalItem(item:AdditionalItem){
    this.additionalItem=item;
    this.additionalItems.push(item);
    //this.addedOneAdditioanlItem.next(item);
    this.price=this.price+item.price;
    console.log("boat details",this.price);
  }

}
