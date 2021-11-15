import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../service/adventure.service';

@Component({
  selector: 'app-adventure-datails-page',
  templateUrl: './adventure-datails-page.component.html',
  styleUrls: ['./adventure-datails-page.component.css']
})
export class AdventureDatailsPageComponent implements OnInit {
  id: number;
  adventure: Adventure;

  constructor(private route: ActivatedRoute,private adventureService:AdventureService) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventure(this.id)
        .subscribe((adventure: Adventure) => this.adventure = adventure);
    });
  }

}
