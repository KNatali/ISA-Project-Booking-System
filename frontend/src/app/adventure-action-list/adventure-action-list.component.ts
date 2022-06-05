import { AdventureFastReservation } from './../model/adventureFastReservation';
import { Component, OnInit } from '@angular/core';
import { AdventureReservationService } from '../service/adventure-reservation.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-adventure-action-list',
  templateUrl: './adventure-action-list.component.html',
  styleUrls: ['./adventure-action-list.component.css']
})
export class AdventureActionListComponent implements OnInit {
  actions:AdventureFastReservation[]=[];
  id:number;
  normal_price:number=0;
  constructor(private adventureFastReservationService:AdventureReservationService ,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {

    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureFastReservationService.getFastReservation(this.id)
      .subscribe(res=>this.actions=res)
    });
  }
  reserveRefrash(){
    this.loadData();
  }
}
