import { RegistrationRequest } from './../model/registrationRequest';
import { Component, OnInit } from '@angular/core';
import { AdminService } from '../service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { EmailMessage } from '../model/emailMessage';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EmailMessageService } from '../service/email-message.service';

@Component({
  selector: 'app-admin-reservation-requests',
  templateUrl: './admin-reservation-requests.component.html',
  styleUrls: ['./admin-reservation-requests.component.css']
})
export class AdminReservationRequestsComponent implements OnInit {
  requests: RegistrationRequest[];



  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService, private router: Router, private route: ActivatedRoute, private emailService: EmailMessageService) { }

  ngOnInit(): void {
    this.getRequests();
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }


  getRequests() {
    this.adminService.getAllRegistrationRequests()
      .subscribe(res => this.requests = res);
  }

  accept(request: RegistrationRequest, id: any) {
    this.adminService.acceptRegistrationRequest(request)
      .subscribe();
    this.requests.forEach((request, index) => {
      if (request.id == id) this.requests.splice(index, 1);
    });
    alert("Successfully sent message to accepted user!")
  }

  reject(request: RegistrationRequest, id: any) {

    sessionStorage.setItem("email", request.userDTO.email);
    this.adminService.rejectRegistrationRequest(request)
      .subscribe(data => {
        alert("sucessfully")
      }, error => {
        alert("Error!")
      });
    this.requests.forEach((request, index) => {
      if (request.id == id) this.requests.splice(index, 1);
    });
  }


}
