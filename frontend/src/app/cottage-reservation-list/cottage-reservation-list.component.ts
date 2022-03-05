import { Component, OnInit } from '@angular/core';
import { CottageReservation } from '../model/cottage-reservation';
import { ClientService } from '../service/client.service';
import { CottageReservationService } from '../service/cottage-reservation.service';

@Component({
  selector: 'app-cottage-reservation-list',
  templateUrl: './cottage-reservation-list.component.html',
  styleUrls: ['./cottage-reservation-list.component.css']
})
export class CottageReservationListComponent implements OnInit {
  reservations: CottageReservation[];
  id:any;
  rate_cottage_button=true;

  constructor(private clientService:ClientService, private cottageResService:CottageReservationService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.clientService.findAllCottageRes(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByDate(){
    this.cottageResService.sortByDate(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByDuration(){
    this.cottageResService.sortByDuration(this.id)
    .subscribe(res=>this.reservations=res)
  }
  SortedByPrice(){
    this.cottageResService.sortByPrice(this.id)
    .subscribe(res=>this.reservations=res)
  }
}