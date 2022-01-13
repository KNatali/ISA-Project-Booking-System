import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BoatOwner } from '../model/boatOwner';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-page',
  templateUrl: './boat-owner-page.component.html',
  styleUrls: ['./boat-owner-page.component.css']
})
export class BoatOwnerPageComponent implements OnInit {

  id: any;
  boatOwner: BoatOwner = new BoatOwner({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: '',
    address: '',
    grade: 0
  });

  constructor(private boatOwnerService: BoatOwnerService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = sessionStorage.getItem("id");
    this.getById();
  }

  getById() {
    this.boatOwnerService.getById(this.id)
      .subscribe(res => this.boatOwner = res)

  }

}
