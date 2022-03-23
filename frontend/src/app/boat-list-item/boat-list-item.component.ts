import { Component, Input, OnInit, Output } from '@angular/core';
import { Boat } from '../model/boat';
import { BoatRevisionService } from '../service/boat-revision.service';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-list-item',
  templateUrl: './boat-list-item.component.html',
  styleUrls: ['./boat-list-item.component.css']
})
export class BoatListItemComponent implements OnInit {
  @Input()
  boats:Boat[];

  averageGrade:number;

  constructor(private boatRevisionService: BoatRevisionService) { }

  ngOnInit(): void {
  }
  LoadAverageGrade(){
    
  }
  

}
