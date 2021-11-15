import { Component, OnInit, Output ,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-search-cottage',
  templateUrl: './search-cottage.component.html',
  styleUrls: ['./search-cottage.component.css']
})
export class SearchCottageComponent implements OnInit {

  name:string;

  @Output()
  NameAdded : EventEmitter<string> =new EventEmitter();
  constructor() { 
    this.name='';
  }

  ngOnInit(): void {
  }
  findCottageByName(){
    this.NameAdded.next(this.name);
  }

}
