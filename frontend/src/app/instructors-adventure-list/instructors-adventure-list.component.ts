import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { ActivatedRoute } from '@angular/router';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructors-adventure-list',
  templateUrl: './instructors-adventure-list.component.html',
  styleUrls: ['./instructors-adventure-list.component.css']
})
export class InstructorsAdventureListComponent implements OnInit {
  adventures:Adventure[];
  id:number;
  constructor(private route: ActivatedRoute,private instructorService: InstructorService ) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData(){
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.instructorService.getInstructorAdventuresClient(this.id)
        .subscribe(res=> this.adventures = res);
    });
  }

}
