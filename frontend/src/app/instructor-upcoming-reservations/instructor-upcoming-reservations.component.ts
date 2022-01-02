import { Component, Input, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-upcoming-reservations',
  templateUrl: './instructor-upcoming-reservations.component.html',
  styleUrls: ['./instructor-upcoming-reservations.component.css']
})
export class InstructorUpcomingReservationsComponent implements OnInit {
  reservations: AdventureReservation[];
  @Input() id: number;
  constructor(private instructorService: InstructorService) { }

  ngOnInit(): void {
    this.getReservations();
  }
  getReservations() {
    this.instructorService.getInstructorReservations(this.id)
      .subscribe(res => this.reservations = res)
  }

}
