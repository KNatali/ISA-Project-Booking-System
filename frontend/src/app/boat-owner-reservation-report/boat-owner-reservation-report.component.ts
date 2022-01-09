import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BoatOwnerReport } from '../model/boatOwnerReport';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-reservation-report',
  templateUrl: './boat-owner-reservation-report.component.html',
  styleUrls: ['./boat-owner-reservation-report.component.css']
})
export class BoatOwnerReservationReportComponent implements OnInit {
  checked: string;
  options: string;
  formValue: FormGroup;
  reservation = JSON.parse(sessionStorage.getItem("boatReservation")!);
  report: BoatOwnerReport = new BoatOwnerReport({
    id: 0,
    boatReservation: this.reservation,
    checkAdmin: false,
    penal: false,
    checked: false,
    content: ""

  })
  constructor(private formBuilder: FormBuilder, private boatOwnerService: BoatOwnerService) { }

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

    this.report.boatReservation = JSON.parse(sessionStorage.getItem("boatReservation")!);
    this.boatOwnerService.sendReservationReport(this.report).subscribe(data => {
      sessionStorage.removeItem("boatReservation");
      let ref = document.getElementById('cancelReport');
      ref?.click();
      this.formValue.reset();

      alert("Successfully added reservation report!");
    }, error => {
      alert(error)
    });
  }

}
