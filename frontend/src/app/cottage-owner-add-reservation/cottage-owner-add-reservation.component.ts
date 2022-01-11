import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Client } from '../model/client';
import { Cottage } from '../model/cottage';
import { CottageReservation } from '../model/cottageReservation';
import { CottageOwner } from '../model/cottageOwner';
import { CottageService } from '../service/cottage.service';
import { CottageOwnerService } from '../service/cottageOwner.service';
import { CottageReservation1Service } from '../service/cottage-reservation1.service';

@Component({
  selector: 'app-cottage-owner-add-reservation',
  templateUrl: './cottage-owner-add-reservation.component.html',
  styleUrls: ['./cottage-owner-add-reservation.component.css']
})
export class CottageOwnerAddReservationComponent implements OnInit {
  reservation: CottageReservation;
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
  cottage: Cottage = new Cottage({
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
    rooms: [],
    state: '',
    street: '',
    city: ''
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
  newReservation: CottageReservation = new CottageReservation({
    reservationStart: '',
    reservationEnd: '',
    numberOfPersons: 0,
    price: 0,
    additionalItems: this.additionalItems,
    client: this.client,
    cottage: this.cottage,
    systemEarning: 0

  })
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  id: number;
  cottages: Cottage[];

  selectedCottage: Cottage;
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private cottageOwnerService: CottageOwnerService, private cottageService: CottageService, private cottageReservationService: CottageReservation1Service) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      reservationStart: ['', Validators.required],
      reservationEnd: ['', Validators.required],
      guests: ['', Validators.required],
      cottage: ['', Validators.required],
    })
    this.reservation = JSON.parse(sessionStorage.getItem("currentReservation")!);

    this.getCottages();
  }
  get registerFormControl() {
    return this.formValue.controls;
  }
  onChange(newValue: any) {
    this.selectedCottage = this.formValue.controls['cottage'].value;
    this.loadAdditionalItems();
  }

  getCottages() {
    this.id = this.reservation.cottage.cottageOwner.id!;
    this.cottageOwnerService.getCottageOwnerCottages(this.id)
      .subscribe(res => {
        this.cottages = res;
      })

  }
  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageAdditionalItems(this.selectedCottage.id!)
        .subscribe((items: AdditionalItem[]) => {
          this.additionalItems = items
        });
    });

  }
  deleteAdditionalItem(index: any) {
    this.additionalItems.splice(index, 1);
  }
  saveReservation() {
    this.selectedCottage = this.formValue.controls['cottage'].value;
    this.newReservation.cottage = this.selectedCottage;
    this.newReservation.additionalItems = this.additionalItems;
    this.newReservation.client = this.reservation.client;
    this.cottageReservationService.saveReservation(this.newReservation)
      .subscribe(res => {
        alert("Sucessfully added new reservation!");
      }, error => {
        alert("The selected reservation start and end period overlaps with your unavailability period! Please choose another one!")
      });
  }

}
