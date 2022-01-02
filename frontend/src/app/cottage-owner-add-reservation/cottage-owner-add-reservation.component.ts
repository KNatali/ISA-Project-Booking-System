import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';

@Component({
  selector: 'app-cottage-owner-add-reservation',
  templateUrl: './cottage-owner-add-reservation.component.html',
  styleUrls: ['./cottage-owner-add-reservation.component.css']
})
export class CottageOwnerAddReservationComponent implements OnInit {

  formValue!: FormGroup;
  additionalItems: Array<AdditionalItem> = [];
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      name: [''],
      price: ['']
    })
  }

}
