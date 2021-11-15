import { Component, OnInit, Output,EventEmitter } from '@angular/core';

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
  constructor() { }

  ngOnInit(): void {
  }
  findBoatByMotorNumber(){
    this.MotorNumberAdded.next(this.motorNumber);
  }
  findBoatByMotorPower(){
    this.MotorPowerAdded.next(this.motorPower);
  }
  findBoatByMotorPowerAndMotorNumber(){
  }
}
