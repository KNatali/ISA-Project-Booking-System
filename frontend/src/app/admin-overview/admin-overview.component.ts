import { AdventureReservationService } from './../service/adventure-reservation.service';
import { SystemEarnings } from './../model/systemEarnings';
import { AdminService } from './../service/admin.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdventureReservation } from '../model/AdventureReservation';

@Component({
  selector: 'app-admin-overview',
  templateUrl: './admin-overview.component.html',
  styleUrls: ['./admin-overview.component.css']
})
export class AdminOverviewComponent implements OnInit {
  formValue: FormGroup;
  adventureReservations: AdventureReservation[];
  earning: SystemEarnings = new SystemEarnings({
    percentage: 0
  })
  total: number = 0;
  constructor(private fb: FormBuilder, private adminService: AdminService, private adventureReservationService: AdventureReservationService) { }

  ngOnInit(): void {
    this.formValue = this.fb.group({

      percentage: ['']

    }

    );
    this.getPercentage();

    this.getAllAdventureReservations();

  }

  getPercentage() {
    this.adminService.getPercentage().subscribe(
      res => {
        this.earning = res;

      }

    );
  }

  getTotal() {
    this.adventureReservations.forEach((value) => {
      this.total = this.total + value.systemEarning;
    });
  }

  submit() {
    this.earning.percentage = this.formValue.controls['percentage'].value;
    this.adminService.setPercentage(this.earning).subscribe(
      res => {
        this.getPercentage();
      }
    )

  }

  getAllAdventureReservations() {
    this.adventureReservationService.allAdventureReservations()
      .subscribe(res => {
        this.adventureReservations = res;
        this.getTotal();
      })
  }

}
