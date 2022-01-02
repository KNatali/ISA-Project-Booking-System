import { InstructorService } from './../service/instructor.service';
import { InstructorReport } from './../model/instructorReport';
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
  reservation = JSON.parse(sessionStorage.getItem("adventureReservation")!);
  report: InstructorReport = new InstructorReport({
    id: 0,
    adventureReservation: this.reservation,
    checkAdmin: false,
    penal: false,
    content: ""

  })
  constructor(private formBuilder: FormBuilder, private instructorService: InstructorService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      content: [''],
      checked: ['']

    })
  }

  saveReport() {
    this.report.content = this.formValue.controls['content'].value;

    if (this.formValue.controls['checked'].value == "check") {
      this.report.checkAdmin = true;
      this.report.penal = false;
    } else if (this.formValue.controls['checked'].value == "penal") {
      alert("This client will get 1 penal")
      this.report.penal = true;
      this.report.checkAdmin = false;
    } else {
      this.report.checkAdmin = false;
      this.report.penal = false;
    }

    this.report.adventureReservation = JSON.parse(sessionStorage.getItem("adventureReservation")!);
    this.instructorService.sendReservationReport(this.report).subscribe(data => {
      sessionStorage.removeItem("adventureReservation");
      let ref = document.getElementById('cancelReport');
      ref?.click();
      this.formValue.reset();

      alert("Successfully added reservation report!");
    }, error => {
      alert(error)
    });



  }

}
