import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Boat } from '../model/boat';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-subscribed-boat-list',
  templateUrl: './subscribed-boat-list.component.html',
  styleUrls: ['./subscribed-boat-list.component.css']
})
export class SubscribedBoatListComponent implements OnInit {
  boats:Boat[]=[];
  id:any;
  constructor(private boatService:BoatService ,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getSubscribedBoats(this.id)
      .subscribe(res=>this.boats=res)
    });
  }
}
