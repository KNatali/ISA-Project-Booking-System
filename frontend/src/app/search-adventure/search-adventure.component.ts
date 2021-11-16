import { Component, OnInit, Output,EventEmitter, ContentChild, Input } from '@angular/core';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-search-adventure',
  templateUrl: './search-adventure.component.html',
  styleUrls: ['./search-adventure.component.css']
})
export class SearchAdventureComponent implements OnInit {
  firstAndLastName:string;
  @Input()
  instructors:Instructor[];
  selectedInstructor:Instructor;
  idd:number;
  @Output()
  //AddedInstructor: EventEmitter<({firstName:string,lastName:string})>=new EventEmitter();
  //AddedInstructor: EventEmitter<string>=new EventEmitter();
  AddedInstructor: EventEmitter<Instructor>=new EventEmitter();
  constructor(private instructorService :InstructorService) {
    this.instructors=[];
    this.selectedInstructor=new Instructor({
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
   }

  ngOnInit(): void {
  }/*
  findByInstructorFirstAndLastName(){
    this.AddedInstructor.next(this.firstAndLastName);
    console.log(this.selectedInstructor.id+"ispis");
  }*/
  findByInstructorFirstAndLastName(){
    this.instructorService.getById(this.selectedInstructor.id)
    .subscribe(res=>this.selectedInstructor=res);
    this.AddedInstructor.next(this.selectedInstructor);
  }
}
