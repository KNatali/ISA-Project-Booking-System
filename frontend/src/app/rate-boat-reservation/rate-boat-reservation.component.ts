import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rate-boat-reservation',
  templateUrl: './rate-boat-reservation.component.html',
  styleUrls: ['./rate-boat-reservation.component.css']
})
export class RateBoatReservationComponent implements OnInit {

  revision_text:string;
  grade:number;
  choices = [1,2,3,4,5];
  choices_for_rate=['owner','boat'];

  constructor() { }

  ngOnInit(): void {
  }
  sendRevision(){}

}
