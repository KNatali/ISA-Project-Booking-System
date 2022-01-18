import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Client } from '../model/client';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-reservation-client',
  templateUrl: './boat-owner-reservation-client.component.html',
  styleUrls: ['./boat-owner-reservation-client.component.css']
})
export class BoatOwnerReservationClientComponent implements OnInit {
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
  constructor(private boatOwnerService: BoatOwnerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatOwnerService.getReservationClient(this.id)
        .subscribe(data => {


          this.client = data;
        }, error => {
          alert(error)
        });
    });
  }

}
