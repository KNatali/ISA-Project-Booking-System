import { Component, OnInit } from '@angular/core';
import { BoatReservation } from '../model/boat-reservation';
import { Revision } from '../model/revision';
import { RevisionType } from '../model/revisionType';
import { SpecificRevision } from '../model/specificRevision';
import { ActivatedRoute } from '@angular/router';
import { BoatReservationService } from '../service/boat-reservation.service';
import { RevisionService } from '../service/revision.service';
import { BoatRevisionService } from '../service/boat-revision.service';

@Component({
  selector: 'app-rate-boat-reservation',
  templateUrl: './rate-boat-reservation.component.html',
  styleUrls: ['./rate-boat-reservation.component.css']
})
export class RateBoatReservationComponent implements OnInit {

  revision_text:string;
  boatReservation:BoatReservation;
  grade:number;
  id:number;
  choices = [1,2,3,4,5];
  choices_for_rate=['owner','boat'];
  revision:Revision=new Revision({
    id:0,
    grade:0,
    revision:'',
    type:RevisionType.Unchecked
  })
  boatRevision=new SpecificRevision({
    id_reservation:0,
    id_revision:0
  })


  constructor(private route: ActivatedRoute,
            private boatReservationService: BoatReservationService,
            private revisionService: RevisionService ,
            private boatRevisionService: BoatRevisionService         
      ) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatReservationService.getById(this.id)
        .subscribe(res => this.boatReservation = res);
    });
  }
  sendRevision(){
    this.revision.grade=this.grade;
    this.revision.revision=this.revision_text;
    this.revisionService.save(this.revision)
      .subscribe(res=>{
        
        this.boatRevision.id_reservation=this.boatReservation.id;
        this.boatRevision.id_revision=res.id;

        this.boatRevisionService.save(this.boatRevision)
      .subscribe()
      })
  }

}
