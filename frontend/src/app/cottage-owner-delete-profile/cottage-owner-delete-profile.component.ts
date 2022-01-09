import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CottageOwner } from '../model/cottageOwner';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { ProfileDeleteRequestType } from '../model/profileDeleteRequestType';
import { User } from '../model/user';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-delete-profile',
  templateUrl: './cottage-owner-delete-profile.component.html',
  styleUrls: ['./cottage-owner-delete-profile.component.css']
})
export class CottageOwnerDeleteProfileComponent implements OnInit {
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
  @Input() cottageOwner: CottageOwner = new CottageOwner({
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
    address: ''
  });
  @Input() id: number;
  request: ProfileDeleteRequest = new ProfileDeleteRequest({
    id: 0,
    userDTO: this.newUser,
    reason: '',
    type: ProfileDeleteRequestType.Unverified
  }
  )
  constructor(private formBuilder: FormBuilder, private cottageOwnerService: CottageOwnerService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }
  sendRequest() {
    this.request.reason = this.formValue.controls['message'].value;
    this.newUser.id = 2;
    this.request.userDTO = this.newUser;
    this.cottageOwnerService.sendDeleteRequest(this.request).subscribe(data => {
      let ref = document.getElementById('cancelDelete');
      ref?.click();
      this.formValue.reset();

      alert("Successfully sent delete request to admin!");
    }, error => {
      alert(error)
    });


  }

}
