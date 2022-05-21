import { Component, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { AdventureReservationService } from '../service/adventure-reservation.service';
import { Complaint } from '../model/complaint';
import { ComplaintInstructorService } from '../service/complaint-instructor.service';

@Component({
  selector: 'app-complain-instructor',
  templateUrl: './complain-instructor.component.html',
  styleUrls: ['./complain-instructor.component.css']
})
export class ComplainInstructorComponent implements OnInit {
  complaint_text:string;
  id:number;
  adventureReservation:AdventureReservation;
  newComplaint=new Complaint({
    id:0,
    description:'',
    idReservation:0
  });
  constructor(private route: ActivatedRoute, 
              private adventureService:AdventureService,
              private adventureReservationService: AdventureReservationService,
              private complaintInstructorService :ComplaintInstructorService) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureReservationService.getById(this.id)
        .subscribe((adventureR: AdventureReservation) => this.adventureReservation = adventureR);
    });
  }
  sendComplaint(){
    this.newComplaint.description=this.complaint_text;
    this.newComplaint.idReservation=this.id;
    console.log(this.complaint_text);
    console.log(this.id);
    this.complaintInstructorService.save(this.newComplaint).subscribe();
  }

}
