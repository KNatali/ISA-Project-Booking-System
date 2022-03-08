import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Boat } from '../model/boat';
import { BoatBehavioralRules } from '../model/boatBehavioralRules';
import { BoatFastReservation } from '../model/boatFastReservation';
import { BoatOwner } from '../model/boatOwner';
import { NavigationEquipment } from '../model/navigationEquipment';
import { BoatService } from '../service/boat.service';

@Component({
  selector: 'app-boat-owner-boat-edit',
  templateUrl: './boat-owner-boat-edit.component.html',
  styleUrls: ['./boat-owner-boat-edit.component.css']
})
export class BoatOwnerBoatEditComponent implements OnInit {
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
  actions: BoatFastReservation[];
  id: number;address = new Address({
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
    address: '',
    grade: 0
  });
  boat: Boat;

  editedBoat: Boat = new Boat({
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
    additionalItems: [],
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
  currentRate = 8;
  formValue0!: FormGroup;
  constructor(private http: HttpClient, private formBuilder: FormBuilder, private route: ActivatedRoute, private boatService: BoatService) { }

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
    this.loadData();
    this.loadBehavioralRules();
    this.loadAdditionalItems();
    this.loadNavigationEquipment();
    this.loadActions();
  }
  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }
  editInformation() {
    this.formValue0.controls['name'].setValue(this.boat.name);
    this.formValue0.controls['street'].setValue(this.boat.address.street);
    this.formValue0.controls['city'].setValue(this.boat.address.city);
    this.formValue0.controls['state'].setValue(this.boat.address.state);
    this.formValue0.controls['maxPersons'].setValue(this.boat.maxPersons);
    this.formValue0.controls['price'].setValue(this.boat.price);
    this.formValue0.controls['cancellationPercentage'].setValue(this.boat.cancellationPercentage);
    this.formValue0.controls['description'].setValue(this.boat.description);

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
    this.editedBoat.name = this.formValue0.value.name;
    this.editedBoat.address.street = this.formValue0.value.street;
    this.editedBoat.address.city = this.formValue0.value.city;
    this.editedBoat.address.state = this.formValue0.value.state;
    this.editedBoat.maxPersons = this.formValue0.value.maxPersons;
    this.editedBoat.price = this.formValue0.value.price;
    if (this.selectedFile != null)
      this.editedBoat.mainPicture = this.selectedFile.name;
    else
      this.editedBoat.mainPicture = this.boat.mainPicture;
    this.editedBoat.cancellationPercentage = this.formValue0.value.cancellationPercentage;
    this.editedBoat.description = this.formValue0.value.description;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.updateBoat(this.id, this.editedBoat)
        .subscribe(data => {
          let ref = document.getElementById('cancel0');
          ref?.click();
          this.formValue0.reset();
          this.loadData();
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
      this.boatService.getBoat(this.id)
        .subscribe((boat: Boat) => {
          this.boat = boat;

          if (this.boat.mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.boat.mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.boat.mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
          this.loader.load().then(() => {
            this.map = new google.maps.Map(document.getElementById("map")!, {
              center: { lat: this.boat.address.latitude, lng: this.boat.address.longitude },
              zoom: 11.5
            })
          })
        });
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBehavioralRules(this.id)
        .subscribe((rules: BoatBehavioralRules[]) => this.boat.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => this.boat.additionalItems = items);
    });
  }
  loadNavigationEquipment() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getNavigationEquipment(this.id)
        .subscribe((items: NavigationEquipment[]) => this.boat.equipment = items);
    });
  }
  loadActions() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatService.getBoatFastReservations(this.id)
        .subscribe((items: BoatFastReservation[]) => this.actions = items);
    });
  }

}
