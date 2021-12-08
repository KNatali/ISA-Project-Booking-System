import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AdventureFastReservation } from '../model/adventureFastReservation';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-actions',
  templateUrl: './instructor-actions.component.html',
  styleUrls: ['./instructor-actions.component.css']
})
export class InstructorActionsComponent implements OnInit {
  fastReservations: AdventureFastReservation[];





  @Input() instructor: Instructor = new Instructor({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: '',

    biography: '',


    grade: 0

  });
  @Input() id: number;
  constructor(private formBuilder: FormBuilder, private instructorService: InstructorService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.fastReservations = [];

    this.getFastReservations();

  }

  getFastReservations() {
    this.instructorService.getInstructorFastReservations(this.id)
      .subscribe(res => this.fastReservations = res)
  }


}
