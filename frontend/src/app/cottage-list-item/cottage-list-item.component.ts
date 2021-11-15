import { Component, Input, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';

@Component({
  selector: 'app-cottage-list-item',
  templateUrl: './cottage-list-item.component.html',
  styleUrls: ['./cottage-list-item.component.css']
})
export class CottageListItemComponent implements OnInit {
  @Input()
  cottage:Cottage;
  
  constructor() { }

  ngOnInit(): void {
  }

}
