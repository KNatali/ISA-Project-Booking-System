import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CottageOwner } from '../model/cottageOwner';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-page',
  templateUrl: './cottage-owner-page.component.html',
  styleUrls: ['./cottage-owner-page.component.css']
})
export class CottageOwnerPageComponent implements OnInit {
  cottageOwner: CottageOwner = new CottageOwner({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    address: '',
    city: '',
    state: '',
    mobile: ''

  });
  id: number;
  constructor(private cottageOwnerService: CottageOwnerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getById();
  }
  getById() {
    this.cottageOwnerService.getById(this.id)
      .subscribe(res => this.cottageOwner = res)
  }

}

