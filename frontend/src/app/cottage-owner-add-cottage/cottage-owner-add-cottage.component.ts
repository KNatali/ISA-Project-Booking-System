import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from '../model/address';
import { Cottage } from '../model/cottage1';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { CottageOwner } from '../model/cottageOwner';
import { Cottage1Service } from '../service/cottage1.service';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-add-cottage',
  templateUrl: './cottage-owner-add-cottage.component.html',
  styleUrls: ['./cottage-owner-add-cottage.component.css']
})
export class CottageOwnerAddCottageComponent implements OnInit {
  id: any;
  formValue!: FormGroup;
  formValue1!: FormGroup;
  formValue2!: FormGroup;
  formValue3!: FormGroup;
  address = new Address({
    id: 0,
    street: '',
    city: '',
    state: '',
    latitude: 0,
    longitude: 0
  })
  cottageOwner: CottageOwner = new CottageOwner({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    address: '',
    street: '',
    city: '',
    state: '',
    mobile: ''

  });
  cottage1: Cottage = new Cottage({
    id: 0,
    name: '',
    address: this.address,
    maxPersons: 0,
    description: '',
    grade: 0,
    price: 0,
    mainPicture: '',
    cottageOwner: this.cottageOwner,
    rules: [],
    items: [],
    cancellationPercentage: 0,
    rooms: []
  });
  rules: Array<CottageBehavioralRules> = [];
  newRule: CottageBehavioralRules = new CottageBehavioralRules({
    rule: ""
  })
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private cottageService: Cottage1Service) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      name: [''],
      street: [''],
      city: [''],
      state: [''],
      maxPersons: [''],
      price: [''],
      cancellationPercentage: [''],
      description: ['']

    })
    this.formValue1 = this.formBuilder.group({
      name: [''],

    })

    this.formValue2 = this.formBuilder.group({
      name: [''],
      price: ['']
    })
    this.formValue3 = this.formBuilder.group({
      rule: [''],

    })
  }
  addRule() {
    this.rules.push(this.newRule);
    this.newRule = new CottageBehavioralRules({
      rule: ""
    })
  }

  deleteRule(index: any) {
    this.rules.splice(index, 1);
  }
  submit() {
    this.cottage1.rules = this.rules;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.addCottage(this.id, this.cottage1)
        .subscribe(data => {
          alert("Successfully added cottages");
          this.router.navigate(['']);
        }, error => {
          alert(error)
        });
    });
  }
}
