import { Component, OnInit } from '@angular/core';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-list',
  templateUrl: './instructor-list.component.html',
  styleUrls: ['./instructor-list.component.css']
})
export class InstructorListComponent implements OnInit {
  instructors:Instructor[];
  constructor(private instructorService:InstructorService) { }

  ngOnInit(): void {
    this.loadData();
    console.log(this.instructors);
  }
  loadData(){
    this.instructorService.getInstructors()
    .subscribe(res=>this.instructors=res)
  }
  sortBaName(){
    this.instructorService.sortByName()
    .subscribe(res=>this.instructors=res)
  }
  sortByGrade(){
    this.instructorService.sortByGrade()
    .subscribe(res=>this.instructors=res)
  }
  sortByCity(){
    this.instructorService.sortByCity()
    .subscribe(res=>this.instructors=res)
  }
}
