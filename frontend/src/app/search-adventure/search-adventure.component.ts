import { Component, OnInit, Output, EventEmitter, ContentChild, Input } from '@angular/core';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-search-adventure',
  templateUrl: './search-adventure.component.html',
  styleUrls: ['./search-adventure.component.css']
})
export class SearchAdventureComponent implements OnInit {
  firstAndLastName: string;
  @Input()
  instructors: Instructor[];
  selectedInstructor: Instructor;
  id: number;
  @Output()
  AddedInstructor: EventEmitter<number> = new EventEmitter();
  constructor(private instructorService: InstructorService) {
    this.instructors = [];
    this.selectedInstructor = new Instructor({
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

      grade:0

    });
  }

  ngOnInit(): void {
  }
  findByInstructor() {
    this.AddedInstructor.next(this.selectedInstructor.id)
  }
}
