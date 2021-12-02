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
  confirmedPassword:string;
  error:string;
  newUser: User=new User({
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
    role:'Client'
  });
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }
  addNewClient(){
    if(this.newUser.password==this.confirmedPassword){
      this.userService.sendEmail(this.newUser)
      .subscribe();
      this.userService.signUp(this.newUser)
      .subscribe();
      this.router.navigate(['sign-in']);
    }else{
      this.error="passwords are not equal";
    }
  }

}
