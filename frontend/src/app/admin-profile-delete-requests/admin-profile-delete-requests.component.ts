import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { AdminService } from '../service/admin.service';
import { EmailMessageService } from '../service/email-message.service';

@Component({
  selector: 'app-admin-profile-delete-requests',
  templateUrl: './admin-profile-delete-requests.component.html',
  styleUrls: ['./admin-profile-delete-requests.component.css']
})
export class AdminProfileDeleteRequestsComponent implements OnInit {
  requests: ProfileDeleteRequest[];
  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService, private router: Router, private route: ActivatedRoute, private emailService: EmailMessageService) { }


  ngOnInit(): void {
    this.getRequests();
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }


  getRequests() {
    this.adminService.getAllProfileDeleteRequests()
      .subscribe(res => this.requests = res);
  }

  accept(request: ProfileDeleteRequest, id: any) {
    this.adminService.acceptProfileDeleteRequests(request)
      .subscribe();
    this.requests.forEach((request, index) => {
      if (request.id == id) this.requests.splice(index, 1);
    });
    alert("Successfully sent message to accepted user!")
  }

  reject(request: ProfileDeleteRequest, id: any) {

    sessionStorage.setItem("email", request.userDTO.email);
    this.adminService.rejectProfileDeleteRequests(request)
      .subscribe();
    this.requests.forEach((request, index) => {
      if (request.id == id) this.requests.splice(index, 1);
    });
  }
}
