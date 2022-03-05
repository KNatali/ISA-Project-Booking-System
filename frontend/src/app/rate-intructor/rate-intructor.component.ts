import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Adventure } from '../model/adventure';
import { AdventureReservation } from '../model/AdventureReservation';
import { AdventureRevision } from '../model/adventureRevision';
import { Client } from '../model/client';
import { Instructor } from '../model/instructor';
import { Revision } from '../model/revision';
import { SpecificRevision } from '../model/specificRevision';
import { RevisionType } from '../model/revisionType';
import { AdventureReservationService } from '../service/adventure-reservation.service';
import { AdventureRevisionService } from '../service/adventure-revision.service';
import { AdventureService } from '../service/adventure.service';
import { ClientService } from '../service/client.service';
import { RevisionService } from '../service/revision.service';

@Component({
  selector: 'app-rate-intructor',
  templateUrl: './rate-intructor.component.html',
  styleUrls: ['./rate-intructor.component.css']
})
export class RateIntructorComponent implements OnInit {
  id:number;
  grade: number;
  adventure:Adventure;
  adventureReservation:AdventureReservation;
  adventureRevision=new SpecificRevision({
    id_reservation:0,
    id_revision:0
  })
  client:Client=new Client({
    id: 0,
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    street: '',
    state: '',
    city: '',
    email: '',
    mobile: '',
  })
  revision:Revision=new Revision({
    id:0,
    grade:0,
    revision:'',
    //client:this.client,
    type:RevisionType.Unchecked//
  })
  revision_saved:Revision=new Revision({
    id:0,
    grade:0,
    revision:'',
    //client:this.client,
    type:RevisionType.Unchecked//
  })
  id_client:any;
  
  constructor(private route: ActivatedRoute, private adventureService:AdventureService,
              private adventureReservationService: AdventureReservationService,
              private clientService:ClientService,
              private revisionService: RevisionService ,
              private adventureRevisionService:AdventureRevisionService  
        ) { }
  choices = [1,2,3,4,5];
  revision_text:string;
  ngOnInit(): void {
    this.id_client = sessionStorage.getItem('id');
    this.loadData1();
    this.loadClient();
    
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventure(this.id)
        .subscribe((adventure: Adventure) => this.adventure = adventure);
    });
  }
  loadData1() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureReservationService.getById(this.id)
        .subscribe((adventureR: AdventureReservation) => this.adventureReservation = adventureR);
    });
  }
  loadClient(){
    this.clientService.getById(this.id_client)
      .subscribe((client:Client)=>this.client=client)
      console.log(this.client)
  }
  sendRevision(){
    this.revision.grade=this.grade;
    this.revision.revision=this.revision_text;
    //this.revision.client=this.client;
    this.revisionService.save(this.revision)
      .subscribe(res=>{
        
        this.adventureRevision.id_reservation=this.adventureReservation.id;
        this.adventureRevision.id_revision=res.id;

        this.adventureRevisionService.save(this.adventureRevision)
      .subscribe()
      })
  }

}
