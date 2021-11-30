import { Component, OnInit } from '@angular/core';
import { ActiveUser } from '../model/user';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user = new ActiveUser();
  isSignedIn: boolean = false;

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.checkUser();
  }

  checkUser(): void {
    let currentUser: ActiveUser = JSON.parse(
      localStorage.getItem('currentUser')!
    );
    if (currentUser.role != '' && currentUser != null) {
      this.user = currentUser;
    }

    this.isSignedIn = this.user.role != '';
  }

}
