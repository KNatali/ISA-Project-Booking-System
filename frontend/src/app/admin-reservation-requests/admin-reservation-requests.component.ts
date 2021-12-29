import { RegistrationRequest } from './../model/registrationRequest';
import { Component, OnInit } from '@angular/core';
import { AdminService } from '../service/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-reservation-requests',
  templateUrl: './admin-reservation-requests.component.html',
  styleUrls: ['./admin-reservation-requests.component.css']
})
export class AdminReservationRequestsComponent implements OnInit {
  requests: RegistrationRequest[];
  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.getRequests();
  }
  getRequests() {
    this.adminService.getAllRegistrationRequests()
      .subscribe(res => this.requests = res);
  }

  accept(request: RegistrationRequest) {
    this.adminService.acceptRegistrationRequest(request)
      .subscribe();
    window.location.reload();
  }

}
