import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Client } from '../model/client';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-reservation-client',
  templateUrl: './cottage-owner-reservation-client.component.html',
  styleUrls: ['./cottage-owner-reservation-client.component.css']
})
export class CottageOwnerReservationClientComponent implements OnInit {
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
  constructor(private cottageOwnerService: CottageOwnerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageOwnerService.getReservationClient(this.id)
        .subscribe(data => {


          this.client = data;
        }, error => {
          alert(error)
        });
    });
  }

}
