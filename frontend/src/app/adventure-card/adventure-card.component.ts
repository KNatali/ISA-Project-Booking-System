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
  @Input('rating') rating: number;
  @Input('starCount') starCount: number;
  @Input('color') color: string;

  @Input()
  adventures: Adventure[];


  constructor() {

  }
  ngOnInit(): void {
    this.adventures = [];
  }







}
