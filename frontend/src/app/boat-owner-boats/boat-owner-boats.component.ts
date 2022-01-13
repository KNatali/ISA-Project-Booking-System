import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Boat } from '../model/boat';
import { BoatOwner } from '../model/boatOwner';
import { BoatReservation } from '../model/boatReservation';
import { BoatOwnerService } from '../service/boat-owner.service';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-owner-boats',
  templateUrl: './boat-owner-boats.component.html',
  styleUrls: ['./boat-owner-boats.component.css']
})
export class BoatOwnerBoatsComponent implements OnInit {
  boats: Boat[];
  boatId: any;
  boatProfile: boolean = false;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  @Input() boatOwner: BoatOwner = new BoatOwner({
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
  @Input() id: number;
  upcomingReservations: BoatReservation[];
  activeReservations: BoatReservation[];
  constructor(private http: HttpClient, private boatOwnerService: BoatOwnerService, private router: Router, private boatService: BoatService) { }

  ngOnInit(): void {
    this.boats = [];
    this.getBoats();
    //this.getActiveReservations();
    //this.getReservations();
  }

  getBoats() {
    this.boatOwnerService.getBoatOwnerBoats(this.id)
      .subscribe(res => {
        this.boats = res;
        for (let i = 0; i < this.boats.length; i++) {
          if (this.boats[i].mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.boats[i].mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.boats[i].mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
        }
      })
  }
  /*getReservations() {
    this.boatOwnerService.getUpcomingBoatOwnerReservations(this.id)
      .subscribe(res => this.upcomingReservations = res)
  }

  getActiveReservations() {
    this.boatOwnerService.getActiveBoatOwnerReservations(this.id)
      .subscribe(res => this.activeReservations = res)
  }*/
  addBoats() {
    alert(this.boatOwner.firstName);
    this.router.navigate(['new']);
  }
  /*checkReservation(id: any): any {
    var count = 0;
    if (this.activeReservations.length > 0) {
      this.activeReservations.forEach((res, index) => {
        if (res.boat.id == id) {
          count = count + 1;
        }

      });
    }
    if (this.upcomingReservations.length > 0) {
      this.upcomingReservations.forEach((res, index) => {
        if (res.boat.id == id) {
          count = count + 1;

        }

      });
    }
    return count;
  }*/

  edit(id: any) {
    this.router.navigate(['/boatOwner/boats/edit', id]);
    /* if (this.checkReservation(id) > 0) {
      
       alert("Can't edit! This adventure has reservation!")
     }
     else
       this.router.navigate(['/instructor/adventures/edit', id]);*/
  }

  delete(id: any) {
    this.boatService.deleteBoat(id).subscribe();
    /*  if (this.checkReservation(id) > 0) {
        alert("Can't delete! This adventure has reservation!")
      }
      else {
        this.adventureService.deleteAdventure(id).subscribe();
      }*/

  }

}
