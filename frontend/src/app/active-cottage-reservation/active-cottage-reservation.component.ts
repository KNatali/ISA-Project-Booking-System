import { Component, OnInit } from '@angular/core';
import { CottageReservation } from '../model/cottage-reservation';
import { CottageReservationService } from '../service/cottage-reservation.service';

@Component({
  selector: 'app-active-cottage-reservation',
  templateUrl: './active-cottage-reservation.component.html',
  styleUrls: ['./active-cottage-reservation.component.css']
})
export class ActiveCottageReservationComponent implements OnInit {
  reservations:CottageReservation[];
  id:any;
  delete_cottage_button:boolean=true;

  constructor(private cottageReservationService:CottageReservationService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.cottageReservationService.activeReservations(this.id)
    .subscribe(res=>this.reservations=res)
  }
  canceledReservaiton(resId:number){
    this.cottageReservationService.cancelReservation(resId)
    .subscribe(res=>this.loadData());
  }
}
