import { AdminService } from './../service/admin.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { InstructorReport } from '../model/instructorReport';

@Component({
  selector: 'app-admin-reservation-reports',
  templateUrl: './admin-reservation-reports.component.html',
  styleUrls: ['./admin-reservation-reports.component.css']
})
export class AdminReservationReportsComponent implements OnInit {
  reports: InstructorReport[];
  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService) { }

  ngOnInit(): void {
    this.getReports();
  }

  getReports() {
    this.adminService.getAllReservationRrports()
      .subscribe(res => this.reports = res);
  }
  accept(report: InstructorReport, id: any) {

    this.reports.forEach((report, index) => {
      if (report.id == id) this.reports.splice(index, 1);
    });
    alert("Successfully sent message to accepted user!")
  }

  reject(report: InstructorReport, id: any) {


    this.reports.forEach((report, index) => {
      if (report.id == id) this.reports.splice(index, 1);
    });
  }

}
