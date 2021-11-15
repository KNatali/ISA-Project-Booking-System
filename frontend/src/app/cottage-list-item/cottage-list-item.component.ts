import { Component, Input, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';
import { CottageService } from '../service/cottage.service';

@Component({
  selector: 'app-cottage-list-item',
  templateUrl: './cottage-list-item.component.html',
  styleUrls: ['./cottage-list-item.component.css']
})
export class CottageListItemComponent implements OnInit {
  @Input()
  cottages:Cottage[];
  
  constructor() { }

  ngOnInit(): void {
  }
}
