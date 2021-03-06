import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Complaint } from '../model/complaint';
import { BoatReservationService } from '../service/boat-reservation.service';
import { RevisionService } from '../service/revision.service';
import { BoatReservation } from '../model/boat-reservation';
import { ComplaintBoatReservationService } from '../service/complaint-boat-reservation.service';

@Component({
  selector: 'app-complain-boat-reservation',
  templateUrl: './complain-boat-reservation.component.html',
  styleUrls: ['./complain-boat-reservation.component.css']
})
export class ComplainBoatReservationComponent implements OnInit {
  choices_for_complain=['owner','boat'];
  complaint_text:string;
  who_to_rate:string;
  id:number;
  newComplaint=new Complaint({
    id:0,
    description:'',
    idReservation:0
  });
  constructor(private route: ActivatedRoute,
              private complaintBoat:ComplaintBoatReservationService
    ) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData(){
    this.route.params.subscribe(param => {
      this.id = param.id;
    });
  }
  sendComplaint(){
    this.newComplaint.description=this.complaint_text;
    this.newComplaint.idReservation=this.id;
    if (this.who_to_rate=="boat"){
      this.complaintBoat.save(this.newComplaint).subscribe();
    }else{
      this.complaintBoat.saveBoatOwnerComlaint(this.newComplaint).subscribe();
    }
    
  }

}
