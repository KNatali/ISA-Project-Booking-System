import { AdminService } from './../service/admin.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdventureComplaint } from '../model/adventureComplaint';

@Component({
  selector: 'app-admin-complaint-answer',
  templateUrl: './admin-complaint-answer.component.html',
  styleUrls: ['./admin-complaint-answer.component.css']
})
export class AdminComplaintAnswerComponent implements OnInit {
  message: '';
  formValue!: FormGroup;
  answer: AdventureComplaint;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }

  sendMessage() {
    this.answer = JSON.parse(sessionStorage.getItem("adventureComplaint")!);
    this.answer.description = this.formValue.controls['message'].value;
    alert(this.answer.description)
    this.adminService.answerComplaint(this.answer).subscribe();

  }

}
