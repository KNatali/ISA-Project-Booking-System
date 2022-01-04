import { AdventureReservationService } from './../service/adventure-reservation.service';
import { AdventureFastReservation } from './../model/adventureFastReservation';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Adventure } from '../model/adventure';
import { InstructorService } from '../service/instructor.service';
import { Address } from '../model/address';
import { Instructor } from '../model/instructor';
import { AdventureService } from '../service/adventure.service';
import { asLiteral } from '@angular/compiler/src/render3/view/util';

@Component({
  selector: 'app-instructor-action-add',
  templateUrl: './instructor-action-add.component.html',
  styleUrls: ['./instructor-action-add.component.css']
})
export class InstructorActionAddComponent implements OnInit {
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
  selectedAdventure: Adventure = new Adventure({
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
  adventures: Adventure[];
  additionalItems: Array<AdditionalItem> = [];
  newAditionalItems: Array<AdditionalItem> = [];
  items: Array<String> = [];

  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })

  newAction: AdventureFastReservation = new AdventureFastReservation({
    reservationStart: '',
    reservationEnd: '',
    validityStart: '',
    validityEnd: '',
    maxPersons: 0,
    price: 0,
    additionalItems: this.additionalItems,
    adventure: this.selectedAdventure
  })
  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private instructorService: InstructorService, private adventureService: AdventureService, private adventureReservationService: AdventureReservationService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      validityStart: ['', Validators.required],
      validityEnd: ['', Validators.required],
      reservationStart: ['', Validators.required],
      reservationEnd: ['', Validators.required],
      guests: ['', Validators.required],
      price: ['', Validators.required],
      adventure: ['', Validators.required],
      checkArray: this.formBuilder.array([])
    })
    this.formValue2 = this.formBuilder.group({
      name: ['']
    })
    this.getAdventures();

  }
  get registerFormControl() {
    return this.formValue.controls;
  }
  onCheckboxChange(e: any) {
    this.checkArray = this.formValue.get('checkArray') as FormArray;

    if (e.target.checked) {
      this.checkArray.push(new FormControl(e.target.value));

    } else {
      let i: number = 0;
      this.checkArray.controls.forEach((item: { value: any; }) => {
        if (item.value == e.target.value) {
          this.checkArray.removeAt(i);
          return;
        }
        i++;
      });
    }
  }
  onChange(newValue: any) {
    this.selectedAdventure = this.formValue.controls['adventure'].value;
    this.loadAdditionalItems();
  }

  getAdventures() {
    this.id = sessionStorage.getItem("id")!;
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

  addAction() {
    this.selectedAdventure = this.formValue.controls['adventure'].value;
    this.newAction.adventure = this.selectedAdventure;
    this.newAction.additionalItems = this.additionalItems;

    this.adventureReservationService.saveFastReservation(this.newAction)
      .subscribe(res => {
        alert("Sucessfully added new action!");
        this.router.navigate(['/instructor/:id']);
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


