import { AdventureCompletedReservationRequest } from './../model/adventureCompletedReservationReport';
import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';

import { Client } from '../model/client';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-instructor-reservation-report',
  templateUrl: './instructor-reservation-report.component.html',
  styleUrls: ['./instructor-reservation-report.component.css']
})
export class InstructorReservationReportComponent implements OnInit {
  checked: string;
  options: string;
  formValue: FormGroup;
  report: AdventureCompletedReservationRequest;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      content: [''],

    })
  }

  saveReport() {
    this.report.content = this.formValue.controls['content'].value
    alert(this.formValue.controls['content'].value);
  }

}
