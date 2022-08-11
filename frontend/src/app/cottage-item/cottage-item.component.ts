import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Cottage } from '../model/cottage';

@Component({
  selector: 'tr[app-cottage-item]',
  templateUrl: './cottage-item.component.html',
  styleUrls: ['./cottage-item.component.css']
})
export class CottageItemComponent implements OnInit {
  @Input()
  cottage:Cottage;
  @Output()
  Unsubsrcibed:EventEmitter<number>=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  Unsubscribe(){
    this.Unsubsrcibed.next(this.cottage.id);
  }

}
