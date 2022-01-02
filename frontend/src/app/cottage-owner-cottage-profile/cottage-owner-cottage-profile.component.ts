import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Cottage } from '../model/cottage1';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { Cottage1Service } from '../service/cottage1.service';

@Component({
  selector: 'app-cottage-owner-cottage-profile',
  templateUrl: './cottage-owner-cottage-profile.component.html',
  styleUrls: ['./cottage-owner-cottage-profile.component.css']
})
export class CottageOwnerCottageProfileComponent implements OnInit {
  cancellation: any;
  id: number;
  cottage1: Cottage;
  currentRate = 8;

  constructor(private route: ActivatedRoute, private router: Router, private cottageService: Cottage1Service) { }

  ngOnInit(): void {
    this.loadData();
    this.loadBehavioralRules();
    this.loadAdditionalItems();
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottage(this.id)
        .subscribe((cottage1: Cottage) => this.cottage1 = cottage1);
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageBehavioralRules(this.id)
        .subscribe((rules: CottageBehavioralRules[]) => this.cottage1.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => this.cottage1.items = items);
    });
  }

  edit() {
    this.router.navigate(['cottageOwner/cottages/edit/:id'])
  }

}
