import { Component, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';
import { SearchForReservation } from '../model/searchForReservation';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-cottage-list-page',
  templateUrl: './cottage-list-page.component.html',
  styleUrls: ['./cottage-list-page.component.css']
})
export class CottageListPageComponent implements OnInit {
  cottages:Cottage[];
  role:any;
  visiable_sort_button:boolean;
  type:string="cottage";

  constructor(private cottageService : CottageService) { }

  ngOnInit(): void {
    this.getCottages();
    this.role=sessionStorage.getItem('role');
    if(this.role=='Client'){
      this.visiable_sort_button=true;
    }else{
      this.visiable_sort_button=false;
    }
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


  Search(obj:SearchForReservation){
    this.cottageService.searchCottagesForReservation(obj).subscribe(res=>this.cottages=res);
    console.log(obj);
  }
  sortByPriceAvailableCottage(){
    this.cottageService.sortByPriceAvailableCottage(this.cottages).subscribe(res=>this.cottages=res);
  }
  sortByGradeAvailableCottage(){
    this.cottageService.sortByGradeAvailableCottage(this.cottages).subscribe(res=>this.cottages=res);
  }
}
