import { Component, OnInit } from '@angular/core';
import { CottageReservationService } from '../service/cottage-reservation.service';
import { ActivatedRoute } from '@angular/router';
import { CottageReservation } from '../model/cottage-reservation';
import { Revision } from '../model/revision';
import { RevisionService } from '../service/revision.service';
import { RevisionType } from '../model/revisionType';
import { SpecificRevision } from '../model/specificRevision';
import { CottageRevisionService } from '../service/cottage-revision.service';
import { CottageOwnerRevisionService } from '../service/cottage-owner-revision.service';

@Component({
  selector: 'app-rate-cottage-reservation',
  templateUrl: './rate-cottage-reservation.component.html',
  styleUrls: ['./rate-cottage-reservation.component.css']
})
export class RateCottageReservationComponent implements OnInit {

  revision_text:string;
  cottageReservation:CottageReservation;
  grade:number;
  who_to_rate:string;
  id:number;
  choices = [1,2,3,4,5];
  choices_for_rate=['owner','cottage'];
  revision:Revision=new Revision({
    id:0,
    grade:0,
    revision:'',
    type:RevisionType.Unchecked
  })
  cottageRevision=new SpecificRevision({
    id_reservation:0,
    id_revision:0
  })
  cottageOwnerRevision=new SpecificRevision({
    id_reservation:0,
    id_revision:0
  })

  constructor(private route: ActivatedRoute,
    private cottageReservationService: CottageReservationService,
    private revisionService: RevisionService ,
    private cottageRevisionService: CottageRevisionService,
    private cottageOwnerRevisionService: CottageOwnerRevisionService
    ) { }

  ngOnInit(): void {
    this.loadData();
    
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageReservationService.getById(this.id)
        .subscribe(res => this.cottageReservation = res);
    });
  }
  sendRevision(){

    this.revision.grade=this.grade;
    this.revision.revision=this.revision_text;
    this.revisionService.save(this.revision)
      .subscribe(res=>{
        if(this.who_to_rate=="cottage"){
          this.cottageRevision.id_reservation=this.cottageReservation.id;
          this.cottageRevision.id_revision=res.id;
          this.cottageRevisionService.save(this.cottageRevision)
          .subscribe()
        }else{
          this.cottageOwnerRevision.id_reservation=this.cottageReservation.id;
          this.cottageOwnerRevision.id_revision=res.id;
          this.cottageOwnerRevisionService.save(this.cottageOwnerRevision)
          .subscribe()
        }
      
      })
  }

}
