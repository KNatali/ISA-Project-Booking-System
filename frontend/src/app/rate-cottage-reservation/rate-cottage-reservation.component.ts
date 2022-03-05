import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rate-cottage-reservation',
  templateUrl: './rate-cottage-reservation.component.html',
  styleUrls: ['./rate-cottage-reservation.component.css']
})
export class RateCottageReservationComponent implements OnInit {

  revision_text:string;
  grade:number;
  choices = [1,2,3,4,5];
  choices_for_rate=['owner','cottage'];

  constructor() { }

  ngOnInit(): void {
  }
  sendRevision(){}

}
