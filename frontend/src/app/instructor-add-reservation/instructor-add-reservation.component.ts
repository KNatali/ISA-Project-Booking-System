import { AdventureReservationService } from './../service/adventure-reservation.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Adventure } from '../model/adventure';
import { AdventureReservation } from '../model/AdventureReservation';
import { Client } from '../model/client';
import { Instructor } from '../model/instructor';
import { AdventureService } from '../service/adventure.service';
import { InstructorService } from '../service/instructor.service';

@Component({
  selector: 'app-instructor-add-reservation',
  templateUrl: './instructor-add-reservation.component.html',
  styleUrls: ['./instructor-add-reservation.component.css']
})
export class InstructorAddReservationComponent implements OnInit {
  reservation: AdventureReservation;
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
  newReservation: AdventureReservation = new AdventureReservation({
    reservationStart: '',
    reservationEnd: '',
    numberOfPersons: 0,
    price: 0,
    additionalItems: this.additionalItems,
    client: this.client,
    adventure: this.adventure

  })
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  id: number;
  adventures: Adventure[];

  selectedAdventure: Adventure;
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private instructorService: InstructorService, private adventureService: AdventureService, private adventureReservationService: AdventureReservationService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      reservationStart: ['', Validators.required],
      reservationEnd: ['', Validators.required],
      guests: ['', Validators.required],
      adventure: ['', Validators.required],



    })
    this.reservation = JSON.parse(sessionStorage.getItem("currentReservation")!);

    this.getAdventures();
  }
  get registerFormControl() {
    return this.formValue.controls;
  }
  onChange(newValue: any) {
    this.selectedAdventure = this.formValue.controls['adventure'].value;
    this.loadAdditionalItems();
  }

  getAdventures() {
    this.id = this.reservation.adventure.instructor.id!;
    this.instructorService.getInstructorAdventures(this.id)
      .subscribe(res => {
        this.adventures = res;
      })

  }
  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureAdditionalItems(this.selectedAdventure.id!)
        .subscribe((items: AdditionalItem[]) => {
          this.additionalItems = items
        });
    });

  }
  deleteAdditionalItem(index: any) {
    this.additionalItems.splice(index, 1);
  }
  saveReservation() {
    this.selectedAdventure = this.formValue.controls['adventure'].value;
    this.newReservation.adventure = this.selectedAdventure;
    this.newReservation.additionalItems = this.additionalItems;
    this.newReservation.client = this.reservation.client;

    this.adventureReservationService.saveReservation(this.newReservation)
      .subscribe(res => {
        alert("Sucessfully added new reservation!");

      }, error => {
        alert("The selected reservation start and end period overlaps with your unavailability period! Please choose another one!")
      });
  }


}
