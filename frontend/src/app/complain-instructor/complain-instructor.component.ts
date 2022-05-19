import { Component, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { AdventureReservationService } from '../service/adventure-reservation.service';

@Component({
  selector: 'app-complain-instructor',
  templateUrl: './complain-instructor.component.html',
  styleUrls: ['./complain-instructor.component.css']
})
export class ComplainInstructorComponent implements OnInit {
  complaint_text:string;
  id:number;
  adventureReservation:AdventureReservation;
  constructor(private route: ActivatedRoute, 
              private adventureService:AdventureService,
              private adventureReservationService: AdventureReservationService,) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureReservationService.getById(this.id)
        .subscribe((adventureR: AdventureReservation) => this.adventureReservation = adventureR);
    });
  }
  sendComplaint(){}

}
