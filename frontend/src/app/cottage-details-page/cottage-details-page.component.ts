import { Component, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';
import { ActivatedRoute } from '@angular/router';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-cottage-details-page',
  templateUrl: './cottage-details-page.component.html',
  styleUrls: ['./cottage-details-page.component.css']
})
export class CottageDetailsPageComponent implements OnInit {
  id: number;
  cottage:Cottage;

  constructor(private route: ActivatedRoute,private cottageService:CottageService) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottage(this.id)
        .subscribe((cottage: Cottage) => this.cottage = cottage);
    });
  }

}
