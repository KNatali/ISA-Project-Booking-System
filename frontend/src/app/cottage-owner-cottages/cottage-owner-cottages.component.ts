import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Cottage } from '../model/cottage1';
import { CottageOwner } from '../model/cottageOwner';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-cottages',
  templateUrl: './cottage-owner-cottages.component.html',
  styleUrls: ['./cottage-owner-cottages.component.css']
})
export class CottageOwnerCottagesComponent implements OnInit {
  cottages: Cottage[];
  cottageId: any;
  cottageProfile: boolean = false;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  @Input() cottageOwner: CottageOwner = new CottageOwner({
    id: 0,
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    address: '',
    street: '',
    city: '',
    state: '',
    email: '',
    mobile: ''

  });
  @Input() id: number;

  constructor(private http: HttpClient, private cottageOwnerService: CottageOwnerService, private router: Router) { }

  ngOnInit(): void {
    this.cottages = [];
    this.getCottages();
  }

  getCottages() {
    this.cottageOwnerService.getCottageOwnerCottages(this.id)
      .subscribe(res => {
        this.cottages = res;
        }
      )
  }

  addCottage() {
    alert(this.cottageOwner.firstName);
    this.router.navigate(['new']);
  }

}
