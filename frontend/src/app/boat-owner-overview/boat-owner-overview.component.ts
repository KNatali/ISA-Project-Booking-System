import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BoatReservation } from '../model/boatReservation';
import { SystemEarnings } from '../model/systemEarnings';
import { AdminService } from '../service/admin.service';
import { BoatReservationService } from '../service/boat-reservation.service';

@Component({
  selector: 'app-boat-owner-overview',
  templateUrl: './boat-owner-overview.component.html',
  styleUrls: ['./boat-owner-overview.component.css']
})
export class BoatOwnerOverviewComponent implements OnInit {
  @Input() id: number;
  formValue: FormGroup;
  activeTab: string = 'CALENDAR';
  boatReservations: BoatReservation[];
  earning: SystemEarnings = new SystemEarnings({
    percentage: 0
  })

  total: number = 0;
  constructor(private fb: FormBuilder, private adminService: AdminService, private boatReservationService: BoatReservationService) { }
  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  startTime: '';
  endTime: '';

  ngOnInit(): void {
    this.formValue = this.fb.group({
      percentage: ['']
    }

    );

  }

  changeTab(tabName: string) {
    this.activeTab = tabName;
  }

}
