import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {
  username: any
  password = ''
  invalidLogin = false;
  @Output()
  LogIn:EventEmitter<void> = new EventEmitter();

  @Input() error: string | null;

  constructor(private router: Router, private userService: UserService,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  login() {
    if (this.username == '' || this.password == '')
      this.error = "Username and password must be filled out";
    else {
      this.loginservice.authenticate(this.username, this.password).subscribe(
        (data: any) => {  
          this.LogIn.next();
          //window.location.reload();
          this.router.navigate(['']);
          this.invalidLogin = false
        },
        (error: { message: string | null; }) => {
          this.invalidLogin = true
          this.error = "Invalid username od password or your account not activate";

        })
    }



  }

}
