import { Component, OnInit } from '@angular/core';
import { BoatService } from '../service/boat.service';
import { Boat } from '../model/boat';
import { SearchForReservation } from '../model/searchForReservation';
import { SearchAvailableBoatByPriceOrGrade } from '../model/searchAvailableBoatByGradeOrPrice';

@Component({
  selector: 'app-boat-list-page',
  templateUrl: './boat-list-page.component.html',
  styleUrls: ['./boat-list-page.component.css']
})
export class BoatListPageComponent implements OnInit {
  sort_boats:Boat[];
  boats:Boat[];
  find_boats:Boat[];
  type:string="boat";
  searchForReserevaiotParametars:SearchForReservation;
  role:any;
  visiable_sort_button:boolean;
  searchByGradeOrPrice: SearchAvailableBoatByPriceOrGrade=new SearchAvailableBoatByPriceOrGrade({
    boats:[],
    priceOrGrade:0
  });

  constructor(private boatService:BoatService) {
    this.boats=[];
   }

  ngOnInit(): void {
    this.getBoats();
    this.role=sessionStorage.getItem('role');
    if(this.role=='Client'){
      this.visiable_sort_button=true;
    }else{
      this.visiable_sort_button=false;
    }
  }

  getBoats(){
    this.boatService.getBoats()
    .subscribe(res=>this.boats=res)
  }
  findBoatByMotorMuber(motorNumber:number){
    this.boatService.findBoatByMotorNumber(motorNumber)
    .subscribe(res=>this.boats=res);
  }
  findBoatByMotorPower(motorPower:number){
    this.boatService.findBoatByMotorPower(motorPower)
    .subscribe(res=>this.boats=res);
  }
  sortByName(){
    this.boatService.sortByName()
    .subscribe(res=>this.boats=res)
  }
  sortByGrade(){
    this.boatService.sortByGrade()
    .subscribe(res=>this.boats=res)
  }
  sortByCity(){
    this.boatService.sortByCity()
    .subscribe(res=>this.boats=res)
  }
  findBoatByMotorPowerAndMotorNumber(motorPower:number,motorNumber:number){

  }
  findByName(name:string){
    this.boatService.findByName(name)
    .subscribe(res=>this.boats=res)
  }
  findByCity(city:string){
    this.boatService.findByCity(city)
    .subscribe(res=>this.boats=res)
  }
  Search(obj:SearchForReservation){
    this.boatService.searchBoatsForReservation(obj).subscribe(res=>{this.boats=res;this.find_boats=res;});
    console.log(obj);
    this.searchForReserevaiotParametars=obj;
  }
  sortByPriceAvailableBoat(){
    this.boatService.sortByPriceAvailableBoat(this.find_boats).subscribe(res=>this.boats=res);
  }
  sortByGradeAvailableBoat(){
    this.boatService.sortByGradeAvailableBoat(this.find_boats).subscribe(res=>this.boats=res);
  }
  findByGradeAvailable(find_by_grade:number){
    //sada treba napraviti objekat koji se salje
    this.searchByGradeOrPrice.boats=this.find_boats;
    this.searchByGradeOrPrice.priceOrGrade=find_by_grade;
    this.boatService.findByGradeAvailable(this.searchByGradeOrPrice)
    .subscribe(res=>this.boats=res);
  }
  findByPriceAvailable(find_by_price:number){
    //sada treba napraviti objekat koji se salje
    this.searchByGradeOrPrice.boats=this.find_boats;
    this.searchByGradeOrPrice.priceOrGrade=find_by_price;
    this.boatService.findByPriceAvailable(this.searchByGradeOrPrice)
    .subscribe(res=>this.boats=res);
  }
}
