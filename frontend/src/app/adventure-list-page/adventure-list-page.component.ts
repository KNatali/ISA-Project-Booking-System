import { UserService } from './../service/user.service';
import { Adventure } from './../model/adventure';
import { Component, Input, OnInit } from '@angular/core';
import { AdventureService } from '../service/adventure.service';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';
import { User } from '../model/user';

@Component({
  selector: 'app-adventure-list-page',
  templateUrl: './adventure-list-page.component.html',
  styleUrls: ['./adventure-list-page.component.css']
})
export class AdventureListPageComponent implements OnInit {

  adventures: Adventure[];
  instructors: Instructor[];

  constructor(private adventureService: AdventureService,
    private instructorService: InstructorService, private userService: UserService) {
    this.adventures = [];
    this.instructors = [];
  }

  ngOnInit(): void {
    this.getAdventures();
    this.getInstructors();
  }

  getAdventures() {
    this.adventureService.getAdventures()
      .subscribe(res => this.adventures = res)
  }
  getInstructors() {
    this.instructorService.getInstructors()
      .subscribe(res => this.instructors = res);
  }
  findByInstructorFirstAndLastName(instructor: Instructor) {
    this.adventureService.findByInstructorFirstAndLastName(instructor.firstName, instructor.lastName)
      .subscribe(res => this.adventures = res);
  }
  findByInstructor(instructorId: number) {
    this.adventureService.findByInstructor(instructorId)
      .subscribe(res => this.adventures = res);
  }
}
