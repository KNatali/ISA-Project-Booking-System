import { RegistrationRequest } from './../model/registrationRequest';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Client } from '../model/client';
import { User } from '../model/user';
import { ClientService } from '../service/client.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {
  choices = ["Client", "Instructor", "CottageOwner", "BoatOwner"];

  value: string;
  showReason: boolean = false;
  @Output() valueChosen: EventEmitter<any> = new EventEmitter();
  confirmedPassword: string;
  showForm: boolean = true;
  registrated: boolean;
  registratedOwner: boolean;
  error: string;
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
  registrationRequest: RegistrationRequest = new RegistrationRequest({
    id: 0,
    userDTO: this.newUser,
    reason: ''
  })
  constructor(private userService: UserService, private router: Router) {
    this.registrated = false;
  }


  ngOnInit(): void {

  }
  choose(value: string) {
    this.valueChosen.emit(value);
    if (this.value != "Client") {
      this.showReason = true;

    }
    else {
      this.showReason = false;

    }


  }
  addNewClient() {

    if (this.newUser.password == this.confirmedPassword) {
      //this.userService.signUp(this.newUser)
      //.subscribe(res=>this.newUser=res);
      //console.log(this.newUser.id);

      this.newUser.role = this.value;
      if (this.value == "Client") {


        this.userService.sendEmail(this.newUser)
          .subscribe();
        this.showForm = false;
        this.registrated = true;
      }
      else {
        this.userService.registerUser(this.registrationRequest)
          .subscribe();
        this.showForm = false;
        this.registratedOwner = true;
      }
    } else {
      this.error = "passwords are not equal";
    }

  }
}
