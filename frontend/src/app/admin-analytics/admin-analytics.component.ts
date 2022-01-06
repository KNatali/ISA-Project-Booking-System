import { AnalyticsService } from './../service/analytics.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdventureReservation } from '../model/AdventureReservation';
import { TimePeriod } from '../model/timePeriod';
import { UnavailabilityType } from '../model/unavailabilityType';
import { AdventureReservationService } from '../service/adventure-reservation.service';

@Component({
  selector: 'app-admin-analytics',
  templateUrl: './admin-analytics.component.html',
  styleUrls: ['./admin-analytics.component.css']
})
export class AdminAnalyticsComponent implements OnInit {

  formValue: FormGroup;
  earningPeriod: any;
  total: number = 0;
  average: number = 0;
  count: number = 0;
  adventureReservations: AdventureReservation[];
  period: TimePeriod = new TimePeriod({
    start: '',
    end: '',
    type: UnavailabilityType.Default
  })

  constructor(private fb: FormBuilder, private adventureReservationService: AdventureReservationService, private analyticsService: AnalyticsService) { }



  ngOnInit(): void {
    this.formValue = this.fb.group({
      startTime: [''],
      endTime: ['']
    }
    );
    this.getAllAdventureReservations();
  }

  getAllAdventureReservations() {
    this.adventureReservationService.allAdventureReservations()
      .subscribe(res => {
        this.adventureReservations = res;
        this.getTotal();
      })
  }
  getTotal() {
    this.adventureReservations.forEach((value) => {
      this.total = this.total + value.systemEarning;
      this.count = this.count + 1;
    });
    this.average = this.total / this.count;
  }

  submit() {
    this.analyticsService.getAdventurePeriodEarnings(this.period)
      .subscribe(res => {
        this.earningPeriod = res;

      })
  }

}
