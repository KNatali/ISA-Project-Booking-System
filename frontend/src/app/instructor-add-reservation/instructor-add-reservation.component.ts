import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';

@Component({
  selector: 'app-instructor-add-reservation',
  templateUrl: './instructor-add-reservation.component.html',
  styleUrls: ['./instructor-add-reservation.component.css']
})
export class InstructorAddReservationComponent implements OnInit {

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
