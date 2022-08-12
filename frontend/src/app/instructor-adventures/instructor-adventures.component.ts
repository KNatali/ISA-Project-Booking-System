import { AdventureService } from './../service/adventure.service';
import { HttpClient } from '@angular/common/http';
import { ReadKeyExpr } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adventure } from '../model/adventure';
import { AdventureReservation } from '../model/AdventureReservation';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-adventures',
  templateUrl: './instructor-adventures.component.html',
  styleUrls: ['./instructor-adventures.component.css']
})
export class InstructorAdventuresComponent implements OnInit {
  adventures: Adventure[];
  adventureId: any;
  adventureProfile: boolean = false;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  @Input() instructor: Instructor = new Instructor({
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

    biography: '',


    grade: 0

  });
  @Input() id: number;
  upcomingReservations: AdventureReservation[];
  activeReservations: AdventureReservation[];
  constructor(private http: HttpClient, private instructorService: InstructorService, private router: Router, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.adventures = [];
    this.getAdventures();
    this.getActiveReservations();
    this.getReservations();

  }

  getAdventures() {
    this.instructorService.getInstructorAdventures(this.id)
      .subscribe(res => {
        this.adventures = res;
        for (let i = 0; i < this.adventures.length; i++) {
          if (this.adventures[i].mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.adventures[i].mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.adventures[i].mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
        }
      })
  }
  getReservations() {
    this.instructorService.getUpcomingInstructorReservations(this.id)
      .subscribe(res => this.upcomingReservations = res)
  }

  getActiveReservations() {
    this.instructorService.getActiveInstructorReservations(this.id)
      .subscribe(res => this.activeReservations = res)
  }

  addAdventure() {
    alert(this.instructor.firstName);
    this.router.navigate(['new']);
  }

  checkReservation(id: any): any {
    var count = 0;
    if (this.activeReservations.length > 0) {
      this.activeReservations.forEach((res, index) => {
        if (res.adventure.id == id) {
          count = count + 1;
        }

      });
    }
    if (this.upcomingReservations.length > 0) {
      this.upcomingReservations.forEach((res, index) => {
        if (res.adventure.id == id) {
          count = count + 1;

        }

      });
    }
    return count;
  }

  edit(id: any) {
    this.router.navigate(['/instructor/adventures/edit', id]);
    /* if (this.checkReservation(id) > 0) {
      
       alert("Can't edit! This adventure has reservation!")
     }
     else
       this.router.navigate(['/instructor/adventures/edit', id]);*/
  }

  delete(id: any) {
    if (this.checkReservation(id) > 0) {
      alert("Can't delete! This adventure has reservation!")
    }
    else {
      this.adventureService.deleteAdventure(id).subscribe(data => {
        alert('Sucessfully deleted!');
        window.location.reload();
      })
    }

  }

}
