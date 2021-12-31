import { Component, Input, OnInit } from '@angular/core';
import { AdventureReservation } from '../model/AdventureReservation';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-active-reservations',
  templateUrl: './instructor-active-reservations.component.html',
  styleUrls: ['./instructor-active-reservations.component.css']
})
export class InstructorActiveReservationsComponent implements OnInit {
  @Input() id: number;
  activeReservations: AdventureReservation[];
  constructor(private instructorService: InstructorService) { }

  ngOnInit(): void {
    this.getActiveReservations();
  }
  getActiveReservations() {
    this.instructorService.getActiveInstructorReservations(this.id)
      .subscribe(res => this.activeReservations = res)
  }

}
