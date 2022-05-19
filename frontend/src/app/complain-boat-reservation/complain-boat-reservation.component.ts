import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-complain-boat-reservation',
  templateUrl: './complain-boat-reservation.component.html',
  styleUrls: ['./complain-boat-reservation.component.css']
})
export class ComplainBoatReservationComponent implements OnInit {
  choices_for_complain=['owner','boat'];
  complaint_text:string;
  who_to_rate:string;
  constructor() { }

  ngOnInit(): void {
  }
  sendComplaint(){}

}
