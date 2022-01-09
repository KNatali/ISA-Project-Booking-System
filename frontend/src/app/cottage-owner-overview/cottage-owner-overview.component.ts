import { SystemEarnings } from './../model/systemEarnings';
import { AdminService } from './../service/admin.service';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CottageReservation } from '../model/cottageReservation';
import { CottageReservationService } from '../service/cottage-reservation.service';


@Component({
  selector: 'app-cottage-owner-overview',
  templateUrl: './cottage-owner-overview.component.html',
  styleUrls: ['./cottage-owner-overview.component.css']
})
export class CottageOwnerOverviewComponent implements OnInit {
  @Input() id: number;
  formValue: FormGroup;
  activeTab: string = 'CALENDAR';
  cottageReservations: CottageReservation[];
  earning: SystemEarnings = new SystemEarnings({
    percentage: 0
  })

  total: number = 0;
  constructor(private fb: FormBuilder, private adminService: AdminService, private cottageReservationService: CottageReservationService) { }
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
