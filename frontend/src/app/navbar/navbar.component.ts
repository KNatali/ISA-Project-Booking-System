import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isActive: boolean = false;


  constructor(public loginService: AuthenticationService) { }

  ngOnInit(): void {

  }



}
