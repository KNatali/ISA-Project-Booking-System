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
  registrated:boolean;
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
  constructor(private userService: UserService, private router: Router) { 
    this.registrated=false;
  }

  ngOnInit(): void {
  }
  addNewClient(){
    if(this.newUser.password==this.confirmedPassword){
      //this.userService.signUp(this.newUser)
      //.subscribe(res=>this.newUser=res);
      //console.log(this.newUser.id);
      this.userService.sendEmail(this.newUser)
      .subscribe();
      this.registrated=true;
    }else{
      this.error="passwords are not equal";
    }

  }
}
