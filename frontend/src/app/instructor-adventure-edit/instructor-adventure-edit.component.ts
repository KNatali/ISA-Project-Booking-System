import { AdventureFastReservation } from './../model/adventureFastReservation';
import { AdditionalItem } from './../model/additionalItem';
import { AdventureBehavioralRules, AdventureBehavioralRulesInterface } from './../model/adventureBehavioralRules';
import { AdventureFishingEquipment } from './../model/adventureFishingEquipment';
import { Component, OnInit, EventEmitter } from '@angular/core';
import { Adventure } from '../model/adventure';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Address } from '../model/address';
import { Instructor } from '../model/instructor';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { Loader } from '@googlemaps/js-api-loader';



@Component({
  selector: 'app-instructor-adventure-edit',
  templateUrl: './instructor-adventure-edit.component.html',
  styleUrls: ['./instructor-adventure-edit.component.css']
})
export class InstructorAdventureEditComponent implements OnInit {
  map: any;
  loader: any;
  selectedFile: File;
  retrievedImage: string;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;
  showAdd: boolean;
  showUpdate: boolean;
  cancellation: any;
  actions: AdventureFastReservation[];
  id: number;
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
  adventure: Adventure;
  additionalItems: AdditionalItem[];
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
  formAction: FormGroup;
  selectedAction: AdventureFastReservation = new AdventureFastReservation({
    reservationStart: '',
    reservationEnd: '',
    validityStart: '',
    validityEnd: '',
    maxPersons: 0,
    price: 0,
    additionalItems: [],
    adventure: this.editedAdventure
  })

  constructor(private http: HttpClient, private formBuilder: FormBuilder, private route: ActivatedRoute, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.loader = new Loader({
      apiKey: 'AIzaSyAHO2M3hFpxZPCjEBmoWnaetSWNC8DHOKI'
    })
    this.formValue0 = this.formBuilder.group({
      name: [''],
      street: [''],
      city: [''],
      state: [''],
      maxPersons: [''],
      price: [''],
      cancellationPercentage: [''],
      description: [''],
      biography: [''],
      image: ['']



    })
    this.formAction = this.formBuilder.group({
      validityStart: [''],
      validityEnd: [''],
      reservationStart: [''],
      reservationEnd: [''],
      maxPersons: [''],
      price: [''],




    });
    this.loadData();
    this.loadEquipment();
    this.loadBehavioralRules();
    this.loadAdditionalItems();
    this.loadActions();

  }
  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    //Select File
    this.selectedFile = event.target.files[0];
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
  //Gets called when the user clicks on submit to upload the image
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

  update() {
    this.editedAdventure.name = this.formValue0.value.name;
    this.editedAdventure.address.street = this.formValue0.value.street;
    this.editedAdventure.address.city = this.formValue0.value.city;
    this.editedAdventure.address.state = this.formValue0.value.state;
    this.editedAdventure.maxPersons = this.formValue0.value.maxPersons;
    this.editedAdventure.price = this.formValue0.value.price;
    if (this.selectedFile != null)
      this.editedAdventure.mainPicture = this.selectedFile.name;
    else
      this.editedAdventure.mainPicture = this.adventure.mainPicture;
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
          this.loadEquipment();
          this.loadBehavioralRules();
          this.loadAdditionalItems();

          alert("Successfully updated  adventure information!");
        }, error => {
          alert(error)
        });
    });
  }
  //Gets called when the user clicks on retieve image button to get the image from back end
  getImage() {
    //Make a call to Sprinf Boot to get the Image Bytes.

    this.http.get('http://localhost:8090/api/get/' + this.imageName)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
  }
  onAdd() {
    this.showAdd = true;
    this.showUpdate = false;
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventure(this.id)
        .subscribe((adventure: Adventure) => {
          this.adventure = adventure;

          if (this.adventure.mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.adventure.mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.adventure.mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
          this.loader.load().then(() => {
            this.map = new google.maps.Map(document.getElementById("map")!, {
              center: { lat: this.adventure.address.latitude, lng: this.adventure.address.longitude },
              zoom: 11.5
            })
          })


        });

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

  loadActions() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureFastReservations(this.id)
        .subscribe((items: AdventureFastReservation[]) => this.actions = items);
    });
  }

  editAction(action: AdventureFastReservation) {
    this.selectedAction = action;
  }


}
