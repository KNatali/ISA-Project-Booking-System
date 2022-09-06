import { ProfileDeleteRequestType } from './../model/profileDeleteRequestType';
import { ProfileDeleteRequest } from './../model/profileDeleteRequest';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Instructor } from '../model/instructor';
import { User } from '../model/user';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-delete-profile',
  templateUrl: './instructor-delete-profile.component.html',
  styleUrls: ['./instructor-delete-profile.component.css']
})
export class InstructorDeleteProfileComponent implements OnInit {
  formValue!: FormGroup;
  message: "";
  newUser: User = new User({
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
    role: '',
    firstLogin: false
  });
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
  request: ProfileDeleteRequest = new ProfileDeleteRequest({
    id: 0,
    userDTO: this.newUser,
    reason: '',
    type: ProfileDeleteRequestType.Unverified
  }
  )
  constructor(private formBuilder: FormBuilder, private instructorService: InstructorService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }
  sendRequest() {
    this.request.reason = this.formValue.controls['message'].value;
   // this.newUser.id = 2;
    this.request.userDTO = this.newUser;
    this.instructorService.sendDeleteRequest(this.request).subscribe(data => {
      let ref = document.getElementById('cancelDelete');
      ref?.click();
      this.formValue.reset();

      alert("Successfully sent delete request to admin!");
    }, error => {
      alert(error)
    });


  }

}
