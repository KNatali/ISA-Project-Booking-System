import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';

@Component({
  selector: 'app-instructor-action-add',
  templateUrl: './instructor-action-add.component.html',
  styleUrls: ['./instructor-action-add.component.css']
})
export class InstructorActionAddComponent implements OnInit {
  formValue2!: FormGroup;
  additionalItems: Array<AdditionalItem> = [];
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formValue2 = this.formBuilder.group({
      name: ['']
    })
  }

  addAdditionalItem() {
    this.additionalItems.push(this.newAdditionalItem);
    this.newAdditionalItem = new AdditionalItem({
      name: "",
      price: 0
    })
  }

  deleteAdditionalItem(index: any) {
    this.additionalItems.splice(index, 1);
  }
}

