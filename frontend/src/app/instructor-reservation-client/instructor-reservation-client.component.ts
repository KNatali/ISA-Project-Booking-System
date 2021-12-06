import { InstructorService } from './../service/instructor.service';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from './../service/client.service';
import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';

@Component({
  selector: 'app-instructor-reservation-client',
  templateUrl: './instructor-reservation-client.component.html',
  styleUrls: ['./instructor-reservation-client.component.css']
})
export class InstructorReservationClientComponent implements OnInit {
  client: Client = new Client({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: ''
  });
  id: number;
  constructor(private instructorService: InstructorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.instructorService.getReservationClient(this.id)
        .subscribe(data => {


          this.client = data;
        }, error => {
          alert(error)
        });
    });
  }

}
