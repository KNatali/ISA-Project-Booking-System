import { MatTabsModule } from '@angular/material/tabs';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-page',
  templateUrl: './instructor-page.component.html',
  styleUrls: ['./instructor-page.component.css']
})
export class InstructorPageComponent implements OnInit {
  id: any;
  instructor: Instructor = new Instructor({
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

  });

  constructor(private instructorService: InstructorService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = sessionStorage.getItem("id");
    this.getById();
  }

  getById() {
    this.instructorService.getById(this.id)
      .subscribe(res => this.instructor = res)
  }

}
