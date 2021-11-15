import { Component, Input, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-cottage-list-item',
  templateUrl: './cottage-list-item.component.html',
  styleUrls: ['./cottage-list-item.component.css']
})
export class CottageListItemComponent implements OnInit {
  
  cottages:Cottage[];
  
  constructor(private cottageService:CottageService) { }

  ngOnInit(): void {
    this.getCottages();
  }
  getCottages(){
    this.cottageService.getCottages()
    .subscribe(res=>this.cottages=res)
  }
}
