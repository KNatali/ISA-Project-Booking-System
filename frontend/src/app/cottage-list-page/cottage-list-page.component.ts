import { Component, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-cottage-list-page',
  templateUrl: './cottage-list-page.component.html',
  styleUrls: ['./cottage-list-page.component.css']
})
export class CottageListPageComponent implements OnInit {
  cottages:Cottage[];

  constructor(private cottageService : CottageService) { }

  ngOnInit(): void {
    this.getCottages();
  }
  getCottages(){
    this.cottageService.getCottages()
    .subscribe(res=>this.cottages=res)
  }
}
