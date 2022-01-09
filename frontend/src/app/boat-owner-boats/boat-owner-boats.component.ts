import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Boat } from '../model/boat';
import { BoatOwner } from '../model/boatOwner';
import { BoatOwnerService } from '../service/boat-owner.service';

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
    grade: 0

  });
  @Input() id: number;

  constructor(private http: HttpClient, private boatOwnerService: BoatOwnerService, private router: Router) { }

  ngOnInit(): void {
    this.boats = [];
    this.getBoats();

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

  addBoats() {
    alert(this.boatOwner.firstName);
    this.router.navigate(['new']);
  }

}
