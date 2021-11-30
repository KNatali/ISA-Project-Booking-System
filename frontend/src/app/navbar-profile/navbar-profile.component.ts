import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActiveUser, User } from '../model/user';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-navbar-profile',
  templateUrl: './navbar-profile.component.html',
  styleUrls: ['./navbar-profile.component.css']
})
export class NavbarProfileComponent implements OnInit {
  url = "http://localhost:8090/api/user";
  id: any;
  user: User;
  constructor(private _http: HttpClient, private loginService: LoginService) { }

  ngOnInit(): void {
    this.viewDashboard().subscribe((data) => {
      this.user = data;
    });
    this.id = this.user.id;
  }

  logOut() {
    this.loginService.logout();
  }

  userName() {
    const user = this.loginService.getCurrentUser();
    return user.firstName;
  }



  viewDashboard() {
    const id = this.loginService.getCurrentUser().id;
    const url = this.url + '/' + id;
    const headers = this.loginService.getHeaders();
    return this._http.get<User>(url, { headers: headers });
  }

}
