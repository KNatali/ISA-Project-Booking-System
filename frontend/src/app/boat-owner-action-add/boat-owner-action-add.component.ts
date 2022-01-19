import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Boat } from '../model/boat';
import { BoatFastReservation } from '../model/boatFastReservation';
import { BoatOwner } from '../model/boatOwner';
import { BoatOwnerService } from '../service/boat-owner.service';
import { BoatReservationService } from '../service/boat-reservation.service';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-owner-action-add',
  templateUrl: './boat-owner-action-add.component.html',
  styleUrls: ['./boat-owner-action-add.component.css']
})
export class BoatOwnerActionAddComponent implements OnInit {
  formValue!: FormGroup;
  formValue2!: FormGroup;
  checkArray: any;
  id: any;
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
    street: '',
    city: '',
    state: '',
    mobile: '',
    address: ''
  });
  selectedBoat: Boat = new Boat({
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
  boats: Boat[];
  additionalItems: Array<AdditionalItem> = [];
  newAditionalItems: Array<AdditionalItem> = [];
  items: Array<String> = [];

  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })

  newAction: BoatFastReservation = new BoatFastReservation({
    reservationStart: '',
    reservationEnd: '',
    validityStart: '',
    validityEnd: '',
    maxPersons: 0,
    price: 0,
    additionalItems: this.additionalItems,
    boat: this.selectedBoat
  })
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private boatOwnerService: BoatOwnerService, private boatService: BoatService, private boatReservationService: BoatReservationService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      validityStart: ['', Validators.required],
      validityEnd: ['', Validators.required],
      reservationStart: ['', Validators.required],
      reservationEnd: ['', Validators.required],
      guests: ['', Validators.required],
      price: ['', Validators.required],
      boat: [''], //Validators.required],
      checkArray: this.formBuilder.array([])
    })
    this.formValue2 = this.formBuilder.group({
      name: ['']
    })
    this.getBoats();

  }
  get registerFormControl() {
    return this.formValue.controls;
  }

  onChange(newValue: any) {
    this.selectedBoat = this.formValue.controls['boat'].value;
    this.loadAdditionalItems();
  }

  getBoats() {
    this.id = sessionStorage.getItem("id")!;
    this.boatOwnerService.getBoatOwnerBoats(this.id)
      .subscribe(res => {
        this.boats = res;
      })

  }
  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBoatAdditionalItems(this.selectedBoat.id!)
        .subscribe((items: AdditionalItem[]) => {
          this.additionalItems = items
        });
    });

  }

  addAction() {
    this.selectedBoat = this.formValue.controls['boat'].value;
    this.newAction.boat = this.selectedBoat;
    this.newAction.additionalItems = this.additionalItems;

    this.boatReservationService.saveFastReservation(this.newAction)
      .subscribe(res => {
        alert("Sucessfully added new action!");
        this.router.navigate(['/boatOwner/:id']);
      }, error => {
        alert("The selected reservation start and end period overlaps with your unavailability period! Please choose another one!")
      });
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
