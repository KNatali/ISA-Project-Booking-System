import { Component, OnInit } from '@angular/core';
import { CottageReservation } from '../model/cottage-reservation';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-cottage-reservation-list',
  templateUrl: './cottage-reservation-list.component.html',
  styleUrls: ['./cottage-reservation-list.component.css']
})
export class CottageReservationListComponent implements OnInit {
  reservations: CottageReservation[];
  id:any;

  constructor(private clientService:ClientService) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('id');
    this.loadData();
  }
  loadData(){
    this.clientService.findAllCottageRes(this.id)
    .subscribe(res=>this.reservations=res)
  }

}
