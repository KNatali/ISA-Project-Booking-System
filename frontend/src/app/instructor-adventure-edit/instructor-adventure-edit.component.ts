import { AdditionalItem } from './../model/additionalItem';
import { AdventureBehavioralRules, AdventureBehavioralRulesInterface } from './../model/adventureBehavioralRules';
import { AdventureFishingEquipment } from './../model/adventureFishingEquipment';
import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Address } from '../model/address';
import { Instructor } from '../model/instructor';



@Component({
  selector: 'app-instructor-adventure-edit',
  templateUrl: './instructor-adventure-edit.component.html',
  styleUrls: ['./instructor-adventure-edit.component.css']
})
export class InstructorAdventureEditComponent implements OnInit {
  showAdd: boolean;
  showUpdate: boolean;
  cancellation: any;
  id: number;
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
  adventure: Adventure;

  editedAdventure: Adventure = new Adventure({
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
  currentRate = 8;
  formValue0!: FormGroup;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.formValue0 = this.formBuilder.group({
      name: [''],
      street: [''],
      city: [''],
      state: [''],
      maxPersons: [''],
      price: [''],
      cancellationPercentage: [''],
      description: [''],
      biography: ['']


    })
    this.loadData();
    this.loadEquipment();
    this.loadBehavioralRules();
    this.loadAdditionalItems();

  }

  editInformation() {
    this.formValue0.controls['name'].setValue(this.adventure.name);
    this.formValue0.controls['street'].setValue(this.adventure.address.street);
    this.formValue0.controls['city'].setValue(this.adventure.address.city);
    this.formValue0.controls['state'].setValue(this.adventure.address.state);
    this.formValue0.controls['maxPersons'].setValue(this.adventure.maxPersons);
    this.formValue0.controls['price'].setValue(this.adventure.price);
    this.formValue0.controls['cancellationPercentage'].setValue(this.adventure.cancellationPercentage);
    this.formValue0.controls['description'].setValue(this.adventure.description);
    this.formValue0.controls['biography'].setValue(this.adventure.instructor.biography);

  }

  update() {
    this.editedAdventure.name = this.formValue0.value.name;
    this.editedAdventure.address.street = this.formValue0.value.street;
    this.editedAdventure.address.city = this.formValue0.value.city;
    this.editedAdventure.address.state = this.formValue0.value.state;
    this.editedAdventure.maxPersons = this.formValue0.value.maxPersons;
    this.editedAdventure.price = this.formValue0.value.price;
    this.editedAdventure.cancellationPercentage = this.formValue0.value.cancellationPercentage;
    this.editedAdventure.description = this.formValue0.value.description;
    this.editedAdventure.instructor.biography = this.formValue0.value.biography;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.updateAdvenuture(this.id, this.editedAdventure)
        .subscribe(data => {
          let ref = document.getElementById('cancel0');
          ref?.click();
          this.formValue0.reset();
          this.loadData();
          alert("Successfully updated  adventure information!");
        }, error => {
          alert(error)
        });
    });
  }
  onAdd() {
    this.showAdd = true;
    this.showUpdate = false;
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventure(this.id)
        .subscribe((adventure: Adventure) => this.adventure = adventure);

    });

  }

  loadEquipment() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureEquipment(this.id)
        .subscribe((equipment: AdventureFishingEquipment[]) => this.adventure.equipment = equipment);
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureBehavioralRules(this.id)
        .subscribe((rules: AdventureBehavioralRules[]) => this.adventure.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => this.adventure.additionalItems = items);
    });
  }


}
