import { Cottage } from '../model/cottage1';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-cottage-card',
  templateUrl: './cottage-card.component.html',
  styleUrls: ['./cottage-card.component.css']
})
export class CottageCardComponent implements OnInit {
  @Input('rating') rating: number;
  @Input('starCount') starCount: number;
  @Input('color') color: string;

  @Input()
  cottages: Cottage[];
  constructor() {
  }
  ngOnInit(): void {
    this.cottages = [];
  }

}
