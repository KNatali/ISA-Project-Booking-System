import { AdventureRuleService } from './../service/adventure-rule.service';
import { AdventureBehavioralRules } from './../model/adventureBehavioralRules';
import { AdditionalItem } from './../model/additionalItem';
import { AdventureFishingEquipment } from './../model/adventureFishingEquipment';
import { AdventureEquipmentEditComponent } from './../adventure-equipment-edit/adventure-equipment-edit.component';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Adventure } from '../model/adventure';
import { Instructor } from '../model/instructor';
import { Address } from '../model/address';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-instructor-add-adventure',
  templateUrl: './instructor-add-adventure.component.html',
  styleUrls: ['./instructor-add-adventure.component.css']
})
export class InstructorAddAdventureComponent implements OnInit {
  selectedFile: File;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
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
  constructor(private http: HttpClient, private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      name: ['', Validators.required],
      street: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      latitude: ['', Validators.required],
      longitude: ['', Validators.required],
      maxPersons: ['', Validators.required],
      price: ['', Validators.required],
      cancellationPercentage: ['', Validators.required],
      description: ['', Validators.required]

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
  get registerFormControl() {
    return this.formValue.controls;
  }

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
  }
  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);

    this.http.post('http://localhost:8090/api/upload', uploadImageData)
      .subscribe((response) => {

      }
      );
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
    if (this.selectedFile == null)
      alert("Please upload image!")
    else {
      this.adventure.mainPicture = this.selectedFile.name;
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


}
