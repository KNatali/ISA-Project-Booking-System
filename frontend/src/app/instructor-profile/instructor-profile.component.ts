import { InstructorService } from './../service/instructor.service';

import { Component, Input, OnInit } from '@angular/core';
import { Instructor } from '../model/instructor';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-instructor-profile',
  templateUrl: './instructor-profile.component.html',
  styleUrls: ['./instructor-profile.component.css']
})
export class InstructorProfileComponent implements OnInit {
  profileShow: boolean = true;
  profileEdit: boolean = false;
  @Input() instructor: Instructor = new Instructor({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    address: '',
    city: '',
    state: '',
    mobile: ''

  });

  constructor() {
  }

  ngOnInit(): void {

  }
  edit() {
    this.profileShow = !this.profileShow;
    this.profileEdit = !this.profileEdit;

  }

}
