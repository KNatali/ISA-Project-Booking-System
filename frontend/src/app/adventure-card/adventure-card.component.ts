import { InstructorService } from './../service/instructor.service';
import { Instructor } from './../model/instructor';
import { Component, Input, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { AdventureService } from '../service/adventure.service';

@Component({
  selector: 'app-adventure-card',
  templateUrl: './adventure-card.component.html',
  styleUrls: ['./adventure-card.component.css']
})
export class AdventureCardComponent implements OnInit {
  adventures: Adventure[];


  constructor(private adventureService: AdventureService) {

  }

  ngOnInit(): void {
    this.adventures = [];
    this.getAdventures();
  }
  getAdventures() {
    this.adventureService.getAdventures()
      .subscribe(res => this.adventures = res)
  }







}
