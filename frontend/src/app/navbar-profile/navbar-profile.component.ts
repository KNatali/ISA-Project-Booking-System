import { AuthenticationService } from './../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar-profile',
  templateUrl: './navbar-profile.component.html',
  styleUrls: ['./navbar-profile.component.css']
})
export class NavbarProfileComponent implements OnInit {
  username: any;
  dash_url = '/';
  id: any;
  role: any;

  @Output()
  LogOut: EventEmitter<void> = new EventEmitter();

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
    this.LogOut.next();
    this.router.navigate(['']);
  }

  showDashboard() {
    this.id = sessionStorage.getItem('id');
    this.role = sessionStorage.getItem('role');
    if (this.role == 'Client') {
      this.router.navigate(['clients', this.id]);

    } else if (this.role == 'Instructor') {
      this.router.navigate(['instructors', this.id]);
    } else if (this.role == 'CottageOwner') {
      this.router.navigate(['cottageOwner', this.id]);

    } else if (this.role == 'Admin' || this.role == 'SysAdmin') {

      this.router.navigate(['admin', this.id]);


    }
  }








}
