import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adventure } from '../model/adventure';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-adventures',
  templateUrl: './instructor-adventures.component.html',
  styleUrls: ['./instructor-adventures.component.css']
})
export class InstructorAdventuresComponent implements OnInit {
  adventures: Adventure[];
  adventureId: any;
  adventureProfile: boolean = false;
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
    mobile: ''

  });
  @Input() id: number;

  constructor(private instructorService: InstructorService, private router: Router) { }

  ngOnInit(): void {
    this.adventures = [];
    this.getAdventures();
  }

  getAdventures() {
    this.instructorService.getInstructorAdventures(this.id)
      .subscribe(res => this.adventures = res)
  }


}
