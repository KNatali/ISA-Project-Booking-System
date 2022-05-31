import { UserService } from './../service/user.service';
import { Adventure } from './../model/adventure';
import { Component, Input, OnInit } from '@angular/core';
import { AdventureService } from '../service/adventure.service';
import { Instructor } from '../model/instructor';
import { InstructorService } from '../service/instructor.service';
import { HttpClient } from '@angular/common/http';
import { SearchForReservation } from '../model/searchForReservation';

@Component({
  selector: 'app-adventure-list-page',
  templateUrl: './adventure-list-page.component.html',
  styleUrls: ['./adventure-list-page.component.css']
})
export class AdventureListPageComponent implements OnInit {
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  adventures: Adventure[];
  instructors: Instructor[];
  type:string="adventure";

  constructor(private http: HttpClient, private adventureService: AdventureService,
    private instructorService: InstructorService, private userService: UserService) {
    this.adventures = [];
    this.instructors = [];
  }

  ngOnInit(): void {
    this.getAdventures();
    this.getInstructors();
  }

  getAdventures() {
    this.adventureService.getAdventures()
      .subscribe(res => {
        this.adventures = res
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
  getInstructors() {
    this.instructorService.getInstructors()
      .subscribe(res => this.instructors = res);
  }
  findByInstructorFirstAndLastName(instructor: Instructor) {
    this.adventureService.findByInstructorFirstAndLastName(instructor.firstName, instructor.lastName)
      .subscribe(res => this.adventures = res);
  }
  findByInstructor(instructorId: number) {
    this.adventureService.findByInstructor(instructorId)
      .subscribe(res => this.adventures = res);
  }
  findByName(name:string){
    this.adventureService.findByName(name)
    .subscribe(res=>this.adventures=res)
  }
  findByCity(city:string){
    this.adventureService.findByCity(city)
    .subscribe(res=>this.adventures=res)
  }
  Search(obj:SearchForReservation){
    this.adventureService.searchAdventuresForReservation(obj).subscribe(res=>this.adventures=res);
    console.log(obj);
  }
  sortByPriceAvailableAdventure(){
    this.adventureService.sortByPriceAvailableAdventure(this.adventures).subscribe(res=>this.adventures=res);
  }
  sortByGradeAvailableAdventure(){
    this.adventureService.sortByGradeAvailableAdventure(this.adventures).subscribe(res=>this.adventures=res);
  }
}
