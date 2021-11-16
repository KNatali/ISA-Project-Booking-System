import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from '../model/boat';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-search-boat',
  templateUrl: './search-boat.component.html',
  styleUrls: ['./search-boat.component.css']
})
export class SearchBoatComponent implements OnInit {
  motorNumber:number;
  motorPower:number;
  @Output()
  MotorNumberAdded:EventEmitter<number>=new EventEmitter();
  @Output()
  MotorPowerAdded:EventEmitter<number>=new EventEmitter();
  @Output()
  MotorPowerAndMotorNumberAdded:EventEmitter<{motorPower:number,motorNumber:number}>=new EventEmitter();
  constructor(private boatService:BoatService) { }

  ngOnInit(): void {
  }
  findBoatByMotorNumber(){
    this.MotorNumberAdded.next(this.motorNumber);
  }
  findBoatByMotorPower(){
    this.MotorPowerAdded.next(this.motorPower);
  }
  findBoatByMotorPowerAndMotorNumber(motorPower:number,motorNumber:number){
    //this.MotorPowerAndMotorNumberAdded.next({motorPower:this.motorPower,motorNumber:this.motorNumber});
    //this.boatService.findBoatByMotorPowerAndMotorNumber(motorPower,motorNumber)
    //.subscribe(res=this.)
  }

}
