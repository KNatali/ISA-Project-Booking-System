import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Cottage } from '../model/cottage1';
import { CottageOwner } from '../model/cottageOwner';
import { CottageReservation } from '../model/cottageReservation';
import { CottageService } from '../service/cottage.service';
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
  upcomingReservations: CottageReservation[];
  activeReservations: CottageReservation[];
  constructor(private http: HttpClient, private cottageOwnerService: CottageOwnerService, private router: Router, private cottageService: CottageService) { }

  ngOnInit(): void {
    this.cottages = [];
    this.getCottages();
    this.getActiveReservations();
    this.getReservations();
  }

  getCottages() {
    this.cottageOwnerService.getCottageOwnerCottages(this.id)
      .subscribe(res => {
        this.cottages = res;
        for (let i = 0; i < this.cottages.length; i++) {
          if (this.cottages[i].mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.cottages[i].mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.cottages[i].mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
        }
      })
  }
  getReservations() {
    this.cottageOwnerService.getUpcomingCottageOwnerReservations(this.id)
      .subscribe(res => this.upcomingReservations = res)
  }

  getActiveReservations() {
    this.cottageOwnerService.getActiveCottageOwnerReservations(this.id)
      .subscribe(res => this.activeReservations = res)
  }

  addCottage() {
    alert(this.cottageOwner.firstName);
    this.router.navigate(['new']);
  }

  checkReservation(id: any): any {
    var count = 0;
    if (this.activeReservations.length > 0) {
      this.activeReservations.forEach((res, index) => {
        if (res.cottage.id == id) {
          count = count + 1;
        }

      });
    }
    if (this.upcomingReservations.length > 0) {
      this.upcomingReservations.forEach((res, index) => {
        if (res.cottage.id == id) {
          count = count + 1;

        }

      });
    }
    return count;
  }

  edit(id: any) {
    this.router.navigate(['/cottageOwner/cottages/edit', id]);
    /* if (this.checkReservation(id) > 0) {
      
       alert("Can't edit! This adventure has reservation!")
     }
     else
       this.router.navigate(['/instructor/adventures/edit', id]);*/
  }

  delete(id: any) {
    this.cottageService.deleteCottage(id).subscribe();
    /*  if (this.checkReservation(id) > 0) {
        alert("Can't delete! This adventure has reservation!")
      }
      else {
        this.adventureService.deleteAdventure(id).subscribe();
      }*/

  }

}
