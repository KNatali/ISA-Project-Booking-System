import { Component, Input, OnInit } from '@angular/core';
import { Instructor } from '../model/instructor';

@Component({
  selector: 'tr[app-instructor-item]',
  templateUrl: './instructor-item.component.html',
  styleUrls: ['./instructor-item.component.css']
})
export class InstructorItemComponent implements OnInit {
  @Input()
  instructor:Instructor;/*= new Instructor({
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
  });*/
  constructor() { 
  }

  ngOnInit(): void {
    console.log(this.instructor)
  }
  seeAdvetures(){
    
  }
}
