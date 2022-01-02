import { Component, OnInit } from '@angular/core';
import { CottageOwner } from '../model/cottageOwner';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-list',
  templateUrl: './cottage-owner-list.component.html',
  styleUrls: ['./cottage-owner-list.component.css']
})
export class CottageOwnerListComponent implements OnInit {
  owners:CottageOwner[];
  constructor(private cottageOwnerService:CottageOwnerService) { }

  ngOnInit(): void {
    this.loadData();
    console.log(this.owners);
  }
  loadData(){
    this.cottageOwnerService.getCottageOwners()
    .subscribe(res=>this.owners=res)
  }
  sortBaName(){
    this.cottageOwnerService.sortByName()
    .subscribe(res=>this.owners=res)
  }
  sortByGrade(){
    this.cottageOwnerService.sortByGrade()
    .subscribe(res=>this.owners=res)
  }
  sortByCity(){
    this.cottageOwnerService.sortByCity()
    .subscribe(res=>this.owners=res)
  }

}
