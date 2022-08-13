import { AdminService } from './../service/admin.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdventureComplaint } from '../model/adventureComplaint';
import { ComplaintAnswer } from '../model/complaintAnswer';

@Component({
  selector: 'app-admin-complaint-answer',
  templateUrl: './admin-complaint-answer.component.html',
  styleUrls: ['./admin-complaint-answer.component.css']
})
export class AdminComplaintAnswerComponent implements OnInit {
  messageClient: '';
  messageOwner: '';
  formValue!: FormGroup;
  complaintAnswer: ComplaintAnswer={
    id:0,
    messageClient:'',
    messageOwner:'',
    ownerId:0,
    clientId:0,
    type:''
  };
  answer: any;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      messageClient: [''],
      messageOwner: [''],

    })
  }

  sendMessage() {
    this.answer = JSON.parse(sessionStorage.getItem("complaint")!);
    this.complaintAnswer.messageClient = this.formValue.controls['messageClient'].value;
    this.complaintAnswer.messageOwner = this.formValue.controls['messageOwner'].value;
    this.complaintAnswer.id = this.answer.id;
    this.complaintAnswer.type = this.answer.type;
    this.complaintAnswer.ownerId=this.answer.ownerId;
    this.complaintAnswer.clientId=this.answer.clientId;
console.log(this.complaintAnswer)
    this.adminService.answerComplaint(this.complaintAnswer)
      .subscribe(data => {
        let ref = document.getElementById('cancelC');
        ref?.click();
        this.formValue.reset();
        alert("Successfully sent answer to client and instructor");
        window.location.reload();
      }, error => {
        this.formValue.reset();
        alert("Error!Try again!")
      });

  }

}
