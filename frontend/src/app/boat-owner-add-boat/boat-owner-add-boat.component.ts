import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Boat } from '../model/boat';
import { BoatBehavioralRules } from '../model/boatBehavioralRules';
import { BoatOwner } from '../model/boatOwner';
import { NavigationEquipment } from '../model/navigationEquipment';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-owner-add-boat',
  templateUrl: './boat-owner-add-boat.component.html',
  styleUrls: ['./boat-owner-add-boat.component.css']
})
export class BoatOwnerAddBoatComponent implements OnInit {
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
  boatOwner: BoatOwner = new BoatOwner({
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
  boat: Boat = new Boat({
    id: 0,
    name: '',
    address: this.address,
    grade: 0,
    price: 0,
    maxPersons: 0,
    description: '',
    mainPicture: 'string;',
    cancellationPercentage: 0,
    owner: this.boatOwner,
    rules: [],
    items: [],
    state: '',
    street: '',
    city: '',
    length: 0,
    motorNumber: 0,
    motorPower: 0,
    maxSpeed: 0,
    capacity: 0,
    equipment: []
  });
  additionalItems: Array<AdditionalItem> = [];
  navigationEquipments: Array<NavigationEquipment> = [];
  rules: Array<BoatBehavioralRules> = [];
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  newNavigationEquipment: NavigationEquipment = new NavigationEquipment({
    name: ""
  })
  newRule: BoatBehavioralRules = new BoatBehavioralRules({
    rule: ""
  })
  constructor(private http: HttpClient, private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private boatService: BoatService) { }

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

  addNavigationEquipment() {
    this.navigationEquipments.push(this.newNavigationEquipment);
    this.newNavigationEquipment = new NavigationEquipment({
      name: ""
    })
  }

  deleteNavigationEquipment(index: any) {
    this.navigationEquipments.splice(index, 1);
  }

  addRule() {

    this.rules.push(this.newRule);
    this.newRule = new BoatBehavioralRules({
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
      this.boat.mainPicture = this.selectedFile.name;
      this.boat.items = this.additionalItems;
      this.boat.equipment = this.navigationEquipments;
      this.boat.rules = this.rules;
      this.route.params.subscribe(param => {
        this.id = param.id;
        this.boatService.addBoat(this.id, this.boat)
          .subscribe(data => {

            alert("Successfully added cottage");
            this.router.navigate(['']);
          }, error => {
            alert(error)
          });
      });
    }

  }

}
