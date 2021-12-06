import { AdventureReservation } from './../model/AdventureReservation';
import { Component, Input, OnInit } from '@angular/core';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-instructor-reservations',
  templateUrl: './instructor-reservations.component.html',
  styleUrls: ['./instructor-reservations.component.css']
})
export class InstructorReservationsComponent implements OnInit {
  reservations: AdventureReservation[];
  completedReservations: AdventureReservation[];
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
  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private instructorService: InstructorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      content: ['']
    })
    this.reservations = [];
    this.completedReservations = [];
    this.getReservations();
    this.getCompletedReservations()
  }

  getReservations() {
    this.instructorService.getInstructorReservations(this.id)
      .subscribe(res => this.reservations = res)
  }

  getCompletedReservations() {
    this.instructorService.getCompletedInstructorReservations(this.id)
      .subscribe(res => this.completedReservations = res)
  }

}
