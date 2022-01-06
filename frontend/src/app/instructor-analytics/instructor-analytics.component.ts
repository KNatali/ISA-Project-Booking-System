import { AnalyticsService } from './../service/analytics.service';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdventureReservation } from '../model/AdventureReservation';
import { TimePeriod } from '../model/timePeriod';
import { UnavailabilityType } from '../model/unavailabilityType';
import { AdventureReservationService } from '../service/adventure-reservation.service';

@Component({
  selector: 'app-instructor-analytics',
  templateUrl: './instructor-analytics.component.html',
  styleUrls: ['./instructor-analytics.component.css']
})
export class InstructorAnalyticsComponent implements OnInit {
  @Input() id: number;
  yearView: boolean = true;
  monthView: boolean = false;
  weekView: boolean = false;
  dataYear: number[] = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  dataMonth: number[] = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  dataWeek: number[] = [0, 0, 0, 0, 0, 0, 0];
  formValue: FormGroup;
  earningPeriod: any;
  averageGrade: any = 0;
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

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels1 = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
  public barChartLabels2 = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15',
    '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'];
  public barChartLabels3 = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

  public barChartType = 'bar';
  public barChartLegend = true;
  public barChartData1 = [
    { data: [10], label: 'Number of reservations' },
  ];
  public barChartData2 = [
    { data: [10], label: 'Number of reservations' },
  ];
  public barChartData3 = [
    { data: [10], label: 'Number of reservations' },
  ];
  ngOnInit(): void {
    this.formValue = this.fb.group({
      startTime: [''],
      endTime: ['']
    }
    );
    this.getAverageGrade(this.id);
    this.getInstructorReservtions(this.id);

  }
  trueYear() {
    this.yearView = true;
    this.monthView = false;
    this.weekView = false;
  }
  trueMonth() {
    this.yearView = false;
    this.monthView = true;
    this.weekView = false;
  }
  trueWeek() {
    this.yearView = false;
    this.monthView = false;
    this.weekView = true;
  }

  getYearData() {
    var now = new Date();
    var yearNow = now.getFullYear();
    for (var i = 0; i < this.adventureReservations.length; i++) {
      var date = new Date(this.adventureReservations[i].reservationStart);
      var month = date.getMonth();

      if (date.getFullYear() == yearNow) {
        this.dataYear[month] = this.dataYear[month] + 1;

      }

    }
    this.barChartData1 = [{ data: this.dataYear, label: 'Number of reservations' }]
  }

  getWeekData() {
    var now = new Date();
    var monthNow = now.getMonth();
    var partNow = Math.floor(now.getDate() / 7);
    var yearNow = now.getFullYear();
    for (var i = 0; i < this.adventureReservations.length; i++) {
      var date = new Date(this.adventureReservations[i].reservationStart);
      var month = date.getMonth();
      var year = date.getFullYear();
      var part = Math.floor(date.getDate() / 7);

      //u istoj sedmici

      if (month == monthNow && year == yearNow && part == partNow) {

        var day = date.getDay();
        if (day == 0) {
          this.dataWeek[6] = this.dataWeek[6] + 1;

        }
        else {
          this.dataWeek[day - 1] = this.dataWeek[day - 1] + 1;
        }

      }
    }
    this.barChartData3 = [{ data: this.dataWeek, label: 'Number of reservations' }]
  }
  getMonthData() {
    for (var i = 0; i < this.adventureReservations.length; i++) {
      var date = new Date(this.adventureReservations[i].reservationStart);
      var month = date.getMonth();
      var year = date.getFullYear();
      var now = new Date();
      var monthNow = now.getMonth();

      var yearNow = now.getFullYear();
      if (month == monthNow && year == yearNow) {
        var day = date.getDate();
        this.dataMonth[day - 1] = this.dataMonth[day - 1] + 1;
      }

    }
    this.barChartData2 = [{ data: this.dataMonth, label: 'Number of reservations' }]
  }


  getAverageGrade(id: number) {
    this.analyticsService.getInstructorAverageGrade(id)
      .subscribe(res => {
        this.averageGrade = res;
      })
  }

  getInstructorReservtions(id: number) {
    this.analyticsService.getInstructorReservations(id)
      .subscribe(res => {
        this.adventureReservations = res;
        this.getTotal();
        this.getYearData();
        this.getMonthData();
        this.getWeekData();
      })
  }
  getTotal() {
    this.adventureReservations.forEach((value) => {
      this.total = this.total + (value.price - value.systemEarning);
      this.count = this.count + 1;
    });
    const factor = 10 ** 2;
    this.average = Math.round((this.total / this.count) * factor) / factor;

  }


  submit() {
    this.analyticsService.getInstructorEarnings(this.period, this.id)
      .subscribe(res => {
        this.earningPeriod = res;

      })
  }

}
