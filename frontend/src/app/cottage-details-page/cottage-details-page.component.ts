import { Component, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage1';
import { ActivatedRoute } from '@angular/router';
import { CottageOwner } from '../model/cottageOwner';
import { Cottage1Service } from '../service/cottage1.service';

@Component({
  selector: 'app-cottage-details-page',
  templateUrl: './cottage-details-page.component.html',
  styleUrls: ['./cottage-details-page.component.css']
})
export class CottageDetailsPageComponent implements OnInit {
  id: number;
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

}
