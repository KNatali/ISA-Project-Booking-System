import { AdventureRuleService } from './../service/adventure-rule.service';
import { AdventureBehavioralRules } from './../model/adventureBehavioralRules';
import { AdditionalItem } from './../model/additionalItem';
import { AdventureFishingEquipment } from './../model/adventureFishingEquipment';
import { AdventureEquipmentEditComponent } from './../adventure-equipment-edit/adventure-equipment-edit.component';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Adventure } from '../model/adventure';
import { Instructor } from '../model/instructor';
import { Address } from '../model/address';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureService } from '../service/adventure.service';

@Component({
  selector: 'app-instructor-add-adventure',
  templateUrl: './instructor-add-adventure.component.html',
  styleUrls: ['./instructor-add-adventure.component.css']
})
export class InstructorAddAdventureComponent implements OnInit {
  id: any;
  formValue!: FormGroup;
  formValue1!: FormGroup;
  formValue2!: FormGroup;
  formValue3!: FormGroup;
  address = new Address({
    id: 0,
    street: '',
    city: '',
    state: ''
  })
  instructor: Instructor = new Instructor({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: '',
    biography: ''

  });


  adventure: Adventure = new Adventure({
    id: 0,
    name: '',
    address: this.address,
    maxPersons: 0,
    description: '',
    averageGrade: 0,
    price: 0,
    mainPicture: '',
    instructor: this.instructor,
    equipment: [],
    rules: [],
    additionalItems: [],
    cancellationPercentage: 0

  });
  equipment: Array<AdventureFishingEquipment> = [];
  additionalItems: Array<AdditionalItem> = [];
  rules: Array<AdventureBehavioralRules> = [];
  newEquipment: AdventureFishingEquipment = new AdventureFishingEquipment({
    name: ""
  })
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  newRule: AdventureBehavioralRules = new AdventureBehavioralRules({
    rule: ""
  })
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private adventureService: AdventureService) { }

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


  addEquipment() {
    this.equipment.push(this.newEquipment);
    this.newEquipment = new AdventureFishingEquipment({
      name: ""
    })
  }

  deleteFieldValue(index: any) {
    this.equipment.splice(index, 1);
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

  addRule() {

    this.rules.push(this.newRule);
    this.newRule = new AdventureBehavioralRules({
      rule: ""
    })
  }

  deleteRule(index: any) {
    this.rules.splice(index, 1);
  }

  submit() {
    this.adventure.equipment = this.equipment;
    this.adventure.additionalItems = this.additionalItems;
    this.adventure.rules = this.rules;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.addAdventure(this.id, this.adventure)
        .subscribe(data => {

          alert("Successfully added adventure");
          this.router.navigate(['']);
        }, error => {
          alert(error)
        });
    });
  }


}
