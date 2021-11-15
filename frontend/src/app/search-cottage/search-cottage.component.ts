import { Component, OnInit, Output ,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-search-cottage',
  templateUrl: './search-cottage.component.html',
  styleUrls: ['./search-cottage.component.css']
})
export class SearchCottageComponent implements OnInit {

  name:string;
  address:string;

  @Output()
  NameAdded : EventEmitter<string> =new EventEmitter();
  @Output()
  AddressAdded : EventEmitter<string> =new EventEmitter();
  constructor() { 
    this.name='';
    this.address='';
  }

  ngOnInit(): void {
  }
  findCottageByName(){
    this.NameAdded.next(this.name);
  }
  findCottageByAddress(){
    this.AddressAdded.next(this.address);
  }

}
