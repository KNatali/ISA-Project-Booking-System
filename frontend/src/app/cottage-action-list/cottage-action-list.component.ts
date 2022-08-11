import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageReservationService } from '../service/cottage-reservation.service';

@Component({
  selector: 'app-cottage-action-list',
  templateUrl: './cottage-action-list.component.html',
  styleUrls: ['./cottage-action-list.component.css']
})
export class CottageActionListComponent implements OnInit {
  actions:CottageFastReservation[]=[];
  id:number;
  constructor(private cottageFastReservationService:CottageReservationService ,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageFastReservationService.getFastReservation(this.id)
      .subscribe(res=>this.actions=res)
    });
  }
  refresh(){
    this.loadData();
  }
}
