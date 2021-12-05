import { InstructorService } from './../service/instructor.service';

import { Component, Input, OnInit } from '@angular/core';
import { Instructor } from '../model/instructor';
import { ActivatedRoute, Router } from '@angular/router';

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
    street: '',
    city: '',
    state: '',
    mobile: '',
    biography: ''


  });
  @Input() id: number;

  constructor(private instructorService: InstructorService, private route: ActivatedRoute
    , private router: Router) {
  }

  ngOnInit(): void {
  }
  edit() {
    this.profileShow = !this.profileShow;
    this.profileEdit = !this.profileEdit;

  }

  submit() {
    this.instructorService.updateInstructor(this.id, this.instructor).subscribe(res => {
      this.goToProfilePage();
    })
  }
  goToProfilePage() {
    this.profileShow = true;
    this.profileEdit = false;

    this.router.navigate(['/instructor/:id']);
  }
  close() {
    window.location.reload();

  }




}
