import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Boat } from '../model/boat';
import { BoatOwner } from '../model/boatOwner';
import { BoatReservation } from '../model/boatReservation';
import { Client } from '../model/client';
import { BoatOwnerService } from '../service/boat-owner.service';
import { BoatReservation1Service } from '../service/boat-reservation1.service';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-owner-add-reservation',
  templateUrl: './boat-owner-add-reservation.component.html',
  styleUrls: ['./boat-owner-add-reservation.component.css']
})
export class BoatOwnerAddReservationComponent implements OnInit {
  reservation: BoatReservation;
  formValue!: FormGroup;
  additionalItems: Array<AdditionalItem> = [];
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
  client: Client = new Client({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: ''
  });
  newReservation: BoatReservation = new BoatReservation({
    reservationStart: '',
    reservationEnd: '',
    numberOfPersons: 0,
    price: 0,
    additionalItems: this.additionalItems,
    client: this.client,
    boat: this.boat,
    systemEarning: 0

  })
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  id: number;
  boats: Boat[];

  selectedBoat: Boat;
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private boatOwnerService: BoatOwnerService, private boatService: BoatService, private boatReservationService: BoatReservation1Service) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      reservationStart: ['', Validators.required],
      reservationEnd: ['', Validators.required],
      guests: ['', Validators.required],
      boat: [''],// Validators.required],
    })
    this.reservation = JSON.parse(sessionStorage.getItem("currentReservation")!);

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
    alert("radi pliz");
    this.id = this.reservation.boat.owner.id!;
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
  deleteAdditionalItem(index: any) {
    this.additionalItems.splice(index, 1);
  }
  saveReservation() {
    this.selectedBoat = this.formValue.controls['boat'].value;
    this.newReservation.boat = this.selectedBoat;
    this.newReservation.additionalItems = this.additionalItems;
    this.newReservation.client = this.reservation.client;
    this.boatReservationService.saveReservation(this.newReservation)
      .subscribe(res => {
        alert("Sucessfully added new reservation!");
        this.router.navigate(['']);
      }, error => {
        alert("The selected reservation start and end period overlaps with your unavailability period! Please choose another one!")
      });
  }

}
