import { Component, OnInit } from '@angular/core';
import { CottageReservation } from '../model/cottage-reservation';
import { ActivatedRoute } from '@angular/router';
import { ComplaintCottageReservationService } from '../service/complaint-cottage-reservation.service';
import { Complaint } from '../model/complaint';
@Component({
  selector: 'app-complain-cottage-reservation',
  templateUrl: './complain-cottage-reservation.component.html',
  styleUrls: ['./complain-cottage-reservation.component.css']
})
export class ComplainCottageReservationComponent implements OnInit {
  complaint_text:string;
  cottageReservation:CottageReservation;
  who_to_rate:string;
  id:number;
  newComplaint=new Complaint({
    id:0,
    description:'',
    idReservation:0
  });
  choices_for_rate=['owner','cottage'];
  constructor(private route: ActivatedRoute,
    private complaintCottage:ComplaintCottageReservationService
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
      if (this.who_to_rate=="cottage"){
        this.complaintCottage.save(this.newComplaint).subscribe();
      }else{
        this.complaintCottage.saveCottageOwnerComplaint(this.newComplaint).subscribe();
      }
    }

}
