import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdditionalItem } from '../model/additionalItem';
import { EmailMessage } from '../model/emailMessage';
import { EmailMessageService } from '../service/email-message.service';

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
  constructor(private formBuilder: FormBuilder, private emailService: EmailMessageService) { }
  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }



  sendMessage() {
    this.rejectMessage.message = this.formValue.controls['message'].value

    this.rejectMessage.email = sessionStorage.getItem("email")!;

    this.emailService.sendRegistrationRejectMessage(this.rejectMessage)
      .subscribe(data => {
        let ref = document.getElementById('cancel');
        ref?.click();
        this.formValue.reset();

        alert("Successfully sent message to rejected user");
      }, error => {
        alert(error)
      });


  }



}
