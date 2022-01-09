import { ProfileDeleteRequest } from './../model/profileDeleteRequest';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdditionalItem } from '../model/additionalItem';
import { EmailMessage } from '../model/emailMessage';
import { EmailMessageService } from '../service/email-message.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-reject-request',
  templateUrl: './admin-reject-request.component.html',
  styleUrls: ['./admin-reject-request.component.css']
})
export class AdminRejectRequestComponent implements OnInit {
  formValue!: FormGroup;
  message: "";
  @Input() rejectMessage: EmailMessage = new EmailMessage({

    message: "",
    email: ""
  })
  answer: ProfileDeleteRequest;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService) { }
  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }



  sendMessage() {
    this.message = this.formValue.controls['message'].value

    this.answer = JSON.parse(sessionStorage.getItem("profileDeleteRequest")!);


    this.adminService.rejectProfileDeleteRequests(this.answer, this.message)
      .subscribe(data => {
        let ref = document.getElementById('cancel');
        ref?.click();
        this.formValue.reset();
        alert("Successfully sent message to rejected user");
      }, error => {
        alert("Error! Please try againg!")
      });



  }



}
