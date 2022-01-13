import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BoatOwner } from '../model/boatOwner';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { ProfileDeleteRequestType } from '../model/profileDeleteRequestType';
import { User } from '../model/user';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-delete-profile',
  templateUrl: './boat-owner-delete-profile.component.html',
  styleUrls: ['./boat-owner-delete-profile.component.css']
})
export class BoatOwnerDeleteProfileComponent implements OnInit {
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
  @Input() boatOwner: BoatOwner = new BoatOwner({
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
    address: '',
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
  constructor(private formBuilder: FormBuilder, private boatOwnerService: BoatOwnerService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }
  sendRequest() {
    this.request.reason = this.formValue.controls['message'].value;
    this.newUser.id = this.id;
    this.request.userDTO = this.newUser;
    this.boatOwnerService.sendDeleteRequest(this.request).subscribe(data => {
      let ref = document.getElementById('cancelDelete');
      ref?.click();
      this.formValue.reset();

      alert("Successfully sent delete request to admin!");
    }, error => {
      alert(error)
    });
  }

}
