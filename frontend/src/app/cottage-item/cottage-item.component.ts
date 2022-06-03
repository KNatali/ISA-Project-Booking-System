import { Component, Input, OnInit } from '@angular/core';
import { Cottage } from '../model/cottage';

@Component({
  selector: 'tr[app-cottage-item]',
  templateUrl: './cottage-item.component.html',
  styleUrls: ['./cottage-item.component.css']
})
export class CottageItemComponent implements OnInit {
  @Input()
  cottage:Cottage;
  constructor() { }

  ngOnInit(): void {
  }

}
