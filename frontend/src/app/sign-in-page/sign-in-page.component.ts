import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActiveUser, AuthRequest } from '../model/user';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {
  request = new AuthRequest();
  errorMessage: string = '';



  constructor(private loginService: LoginService, private route: Router) { }

  ngOnInit(): void {

  }

  login() {
    if (this.request.username == '' || this.request.password == '') {
      this.errorMessage = 'Username or password missing.';
    } else {
      this.loginService.login(this.request).subscribe(
        (data) => this.successfulLogin(data),
        (res) => (this.errorMessage = 'Invalid username or password.')
      );
    }
  }

  successfulLogin(data: ActiveUser) {
    this.errorMessage = '';
    console.log(data);
    this.loginService.loginSetUser(data);
  }


}
