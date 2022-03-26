import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Cottage } from '../model/cottage';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageOwner } from '../model/cottageOwner';
import { CottageReservationService } from '../service/cottage-reservation.service';
import { CottageService } from '../service/cottage.service';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-action-add',
  templateUrl: './cottage-owner-action-add.component.html',
  styleUrls: ['./cottage-owner-action-add.component.css']
})
export class CottageOwnerActionAddComponent implements OnInit {
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
  cottageOwner: CottageOwner = new CottageOwner({
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
  selectedCottage: Cottage = new Cottage({
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
  cottages: Cottage[];
  additionalItems: Array<AdditionalItem> = [];
  newAditionalItems: Array<AdditionalItem> = [];
  items: Array<String> = [];

  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })

  newAction: CottageFastReservation = new CottageFastReservation({
    reservationStart: '',
    reservationEnd: '',
    validityStart: '',
    validityEnd: '',
    maxPersons: 0,
    price: 0,
    items: this.additionalItems,
    cottage: this.selectedCottage
  })
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private cottageOwnerService: CottageOwnerService, private cottageService: CottageService, private cottageReservationService: CottageReservationService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      validityStart: ['', Validators.required],
      validityEnd: ['', Validators.required],
      reservationStart: ['', Validators.required],
      reservationEnd: ['', Validators.required],
      guests: ['', Validators.required],
      price: ['', Validators.required],
      cottage: ['', Validators.required],
      checkArray: this.formBuilder.array([])
    })
    this.formValue2 = this.formBuilder.group({
      name: ['']
    })
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
    this.id = sessionStorage.getItem("id")!;
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

  addAction() {
    this.selectedCottage = this.formValue.controls['cottage'].value;
    this.newAction.cottage = this.selectedCottage;
    this.newAction.items = this.additionalItems;

    this.cottageReservationService.saveFastReservation(this.newAction)
      .subscribe(res => {
        alert("Sucessfully added new action!");
        this.router.navigate(['/cottageOwner/:id']);
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
