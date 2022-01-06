import { AdventureReservationService } from './../service/adventure-reservation.service';
import { SystemEarnings } from './../model/systemEarnings';
import { AdminService } from './../service/admin.service';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdventureReservation } from '../model/AdventureReservation';

@Component({
  selector: 'app-instructor-overview',
  templateUrl: './instructor-overview.component.html',
  styleUrls: ['./instructor-overview.component.css']
})
export class InstructorOverviewComponent implements OnInit {
  @Input() id: number;
  formValue: FormGroup;
  activeTab: string = 'CALENDAR';
  adventureReservations: AdventureReservation[];
  earning: SystemEarnings = new SystemEarnings({
    percentage: 0
  })

  total: number = 0;
  constructor(private fb: FormBuilder, private adminService: AdminService, private adventureReservationService: AdventureReservationService) { }
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
