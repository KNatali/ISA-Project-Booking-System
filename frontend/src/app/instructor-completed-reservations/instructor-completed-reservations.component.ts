import { Component, Input, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-completed-reservations',
  templateUrl: './instructor-completed-reservations.component.html',
  styleUrls: ['./instructor-completed-reservations.component.css']
})
export class InstructorCompletedReservationsComponent implements OnInit {
  completedReservations: AdventureReservation[];
  @Input() id: number;
  constructor(private instructorService: InstructorService) { }

  ngOnInit(): void {
    this.getCompletedReservations();
  }

  getCompletedReservations() {
    this.instructorService.getCompletedInstructorReservations(this.id)
      .subscribe(res => this.completedReservations = res)
  }

  addReport(reservation: AdventureReservation) {
    sessionStorage.setItem("adventureReservation", JSON.stringify(reservation));
  }


}
