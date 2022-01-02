import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adventure } from '../model/adventure';
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

  constructor(private http: HttpClient, private instructorService: InstructorService, private router: Router) { }

  ngOnInit(): void {
    this.adventures = [];
    this.getAdventures();

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

  addAdventure() {
    alert(this.instructor.firstName);
    this.router.navigate(['new']);
  }


}
