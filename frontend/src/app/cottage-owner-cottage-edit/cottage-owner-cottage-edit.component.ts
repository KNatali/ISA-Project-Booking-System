import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Cottage } from '../model/cottage1';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { CottageOwner } from '../model/cottageOwner';
import { Cottage1Service } from '../service/cottage1.service';

@Component({
  selector: 'app-cottage-owner-cottage-edit',
  templateUrl: './cottage-owner-cottage-edit.component.html',
  styleUrls: ['./cottage-owner-cottage-edit.component.css']
})
export class CottageOwnerCottageEditComponent implements OnInit {
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
  id: number;
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
  cottage1: Cottage;

  editedCottage: Cottage = new Cottage({
    id: 0,
    name: '',
    address: this.address,
    grade: 0,
    price: 0,
    maxPersons: 0,
    description: '',
    mainPicture: 'string;',
    cancellationPercentage: 0,
    cottageOwner: this.cottageOwner,
    rules: [],
    items: [],
    rooms: [],
  });
  currentRate = 8;
  formValue0!: FormGroup;
  constructor(private http: HttpClient, private formBuilder: FormBuilder, private route: ActivatedRoute, private cottageService: Cottage1Service) { }

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

  }
  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }
  editInformation() {
    this.formValue0.controls['name'].setValue(this.cottage1.name);
    this.formValue0.controls['street'].setValue(this.cottage1.address.street);
    this.formValue0.controls['city'].setValue(this.cottage1.address.city);
    this.formValue0.controls['state'].setValue(this.cottage1.address.state);
    this.formValue0.controls['maxPersons'].setValue(this.cottage1.maxPersons);
    this.formValue0.controls['price'].setValue(this.cottage1.price);
    this.formValue0.controls['cancellationPercentage'].setValue(this.cottage1.cancellationPercentage);
    this.formValue0.controls['description'].setValue(this.cottage1.description);

  }
  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    alert(this.selectedFile.name);
    //Make a call to the Spring Boot Application to save the image
    this.http.post('http://localhost:8090/api/upload', uploadImageData)
      .subscribe((response) => {
        /*  if (response.status === 200) {
            this.message = 'Image uploaded successfully';
          } else {
            this.message = 'Image not uploaded successfully';
          }*/
      }
      );
  }

  update() {
    this.editedCottage.name = this.formValue0.value.name;
    this.editedCottage.address.street = this.formValue0.value.street;
    this.editedCottage.address.city = this.formValue0.value.city;
    this.editedCottage.address.state = this.formValue0.value.state;
    this.editedCottage.maxPersons = this.formValue0.value.maxPersons;
    this.editedCottage.price = this.formValue0.value.price;
    if (this.selectedFile != null)
      this.editedCottage.mainPicture = this.selectedFile.name;
    else
      this.editedCottage.mainPicture = this.cottage1.mainPicture;
    this.editedCottage.cancellationPercentage = this.formValue0.value.cancellationPercentage;
    this.editedCottage.description = this.formValue0.value.description;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.updateCottage(this.id, this.editedCottage)
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
    alert(this.imageName)
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
      this.cottageService.getCottage(this.id)
        .subscribe((cottage1: Cottage) => {
          this.cottage1 = cottage1;

          if (this.cottage1.mainPicture.substring(0, 7) != "/assets") {
            this.http.get('http://localhost:8090/api/get/' + this.cottage1.mainPicture)
              .subscribe(
                res => {
                  this.retrieveResonse = res;
                  this.base64Data = this.retrieveResonse.picByte;
                  this.cottage1.mainPicture = 'data:image/jpeg;base64,' + this.base64Data;
                }
              );
          }
          this.loader.load().then(() => {
            this.map = new google.maps.Map(document.getElementById("map")!, {
              center: { lat: this.cottage1.address.latitude, lng: this.cottage1.address.longitude },
              zoom: 11.5
            })
          })
        });
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageBehavioralRules(this.id)
        .subscribe((rules: CottageBehavioralRules[]) => this.cottage1.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageService.getCottageAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => this.cottage1.items = items);
    });
  }
}
