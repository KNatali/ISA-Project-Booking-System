import { Component, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-cottage-list-page',
  templateUrl: './cottage-list-page.component.html',
  styleUrls: ['./cottage-list-page.component.css']
})
export class CottageListPageComponent implements OnInit {
  cottages:Cottage[];

  constructor(private cottageService : CottageService) { }

  ngOnInit(): void {
    this.getCottages();
  }
  getCottages(){
    this.cottageService.getCottages()
    .subscribe(res=>this.cottages=res)
  }
  findCottageByName(name:string){
    this.cottageService.findCottageByName(name)
    .subscribe(res=>this.cottages=res);
  }
  findCottageByAddress(address:string){
    this.cottageService.findCottageByAddress(address)
    .subscribe(res=>this.cottages=res);
  }
  sortByName(){
    this.cottageService.sortByName()
    .subscribe(res=>this.cottages=res)
  }
  sortByCity(){
    this.cottageService.sortByCity()
    .subscribe(res=>this.cottages=res)
  }
  sortByGrade(){
    this.cottageService.sortByGrade()
    .subscribe(res=>this.cottages=res)
  }

}
