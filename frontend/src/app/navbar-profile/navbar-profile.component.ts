import { AuthenticationService } from './../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar-profile',
  templateUrl: './navbar-profile.component.html',
  styleUrls: ['./navbar-profile.component.css']
})
export class NavbarProfileComponent implements OnInit {
  username: any;
  dash_url = '/';

  constructor(private _http: HttpClient, private loginService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('username');

    /* if (currentUser.role != 'LOGGED_OUT' && currentUser != null) {
       this.dash_url = "adventures";
       this.user = currentUser;
       switch (this.user.role) {
         case 'Client':
           this.dash_url = "adventures";
           break;
         case 'Instructor':
           this.dash_url = "adventures";
           break;
         case 'CottageOwner':
           this.dash_url = "adventures";
           break;
         case 'BoatOwner':
           this.dash_url = "adventures";
           break;
         case 'Admin':
           this.dash_url = "adventures";
           break;
       }
     }*/
  }

  logOut() {
    this.loginService.logOut();
    this.router.navigate(['']);
  }

  showDashboard() {
    this.router.navigate(['instructors/1']);
  }








}
