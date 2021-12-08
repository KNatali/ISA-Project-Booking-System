import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InstructorService } from '../service/instructor.service';
import { Adventure } from '../model/adventure';

@Component({
  selector: 'app-instructor-adventure-list',
  templateUrl: './instructor-adventure-list.component.html',
  styleUrls: ['./instructor-adventure-list.component.css']
})
export class InstructorAdventureListComponent implements OnInit {
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
