import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageOwner } from '../model/cottageOwner';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-actions',
  templateUrl: './cottage-owner-actions.component.html',
  styleUrls: ['./cottage-owner-actions.component.css']
})
export class CottageOwnerActionsComponent implements OnInit {
  fastReservations: CottageFastReservation[];

  @Input() cottageOwner: CottageOwner = new CottageOwner({
    id: 0,
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    address: '',
    street: '',
    city: '',
    state: '',
    email: '',
    mobile: ''

  });
  @Input() id: number;
  constructor(private formBuilder: FormBuilder, private cottageOwnerService: CottageOwnerService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.fastReservations = [];

    this.getFastReservations();

  }

  getFastReservations() {
    this.cottageOwnerService.getCottageOwnerFastReservations(this.id)
      .subscribe(res => this.fastReservations = res)
  }

}
