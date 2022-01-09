import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CottageOwnerReport } from '../model/cottageOwnerReport';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-reservation-report',
  templateUrl: './cottage-owner-reservation-report.component.html',
  styleUrls: ['./cottage-owner-reservation-report.component.css']
})
export class CottageOwnerReservationReportComponent implements OnInit {
  checked: string;
  options: string;
  formValue: FormGroup;
  reservation = JSON.parse(sessionStorage.getItem("cottageReservation")!);
  report: CottageOwnerReport = new CottageOwnerReport({
    id: 0,
    cottageReservation: this.reservation,
    checkAdmin: false,
    penal: false,
    checked: false,
    content: ""

  })
  constructor(private formBuilder: FormBuilder, private cottageOwnerService: CottageOwnerService) { }

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

    this.report.cottageReservation = JSON.parse(sessionStorage.getItem("cottageReservation")!);
    this.cottageOwnerService.sendReservationReport(this.report).subscribe(data => {
      sessionStorage.removeItem("cottageReservation");
      let ref = document.getElementById('cancelReport');
      ref?.click();
      this.formValue.reset();

      alert("Successfully added reservation report!");
    }, error => {
      alert(error)
    });
  }

}
