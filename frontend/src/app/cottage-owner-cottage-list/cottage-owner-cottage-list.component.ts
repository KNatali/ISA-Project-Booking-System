import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cottage } from '../model/cottage1';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-cottage-list',
  templateUrl: './cottage-owner-cottage-list.component.html',
  styleUrls: ['./cottage-owner-cottage-list.component.css']
})
export class CottageOwnerCottageListComponent implements OnInit {
  cottages:Cottage[];
  id:number;
  constructor(private route: ActivatedRoute,private cottageOwnerService: CottageOwnerService ) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData(){
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageOwnerService.getCottageOwnerCottagesClient(this.id)
        .subscribe(res=> this.cottages = res);
    });
  }

}
