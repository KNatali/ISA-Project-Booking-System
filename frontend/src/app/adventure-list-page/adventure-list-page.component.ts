import { Adventure } from './../model/adventure';
import { Component, Input, OnInit } from '@angular/core';
import { AdventureService } from '../service/adventure.service';

@Component({
  selector: 'app-adventure-list-page',
  templateUrl: './adventure-list-page.component.html',
  styleUrls: ['./adventure-list-page.component.css']
})
export class AdventureListPageComponent implements OnInit {

  adventures: Adventure[];

  constructor(private adventureService: AdventureService) {
    this.adventures = [];
  }

  ngOnInit(): void {
    this.getAdventures();
  }

  getAdventures() {
    this.adventureService.getAdventures()
      .subscribe(res => this.adventures = res)
  }
  findByInstructorFirstAndLastName(firstAndLastName:string){
    var splitted = firstAndLastName.split(" ");
    const firstName = splitted[0];
    const lastName=splitted[1];
    console.log(firstName+lastName);
    this.adventureService.findByInstructorFirstAndLastName(firstName,lastName)
    .subscribe(res=>this.adventures=res);
  }
}
