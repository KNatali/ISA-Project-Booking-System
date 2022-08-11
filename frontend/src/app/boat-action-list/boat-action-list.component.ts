import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BoatFastReservation } from '../model/boatFastReservation';
import { BoatReservationService } from '../service/boat-reservation.service';

@Component({
  selector: 'app-boat-action-list',
  templateUrl: './boat-action-list.component.html',
  styleUrls: ['./boat-action-list.component.css']
})
export class BoatActionListComponent implements OnInit {
  actions:BoatFastReservation[]=[];
  id:number;
  constructor(private boatFastReservationService:BoatReservationService ,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatFastReservationService.getFastReservation(this.id)
      .subscribe(res=>this.actions=res)
    });
  }
  refresh(){
    this.loadData();
  }
}
