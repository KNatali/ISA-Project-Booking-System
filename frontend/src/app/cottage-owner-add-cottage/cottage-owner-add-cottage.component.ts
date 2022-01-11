import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { Address } from '../model/address';
import { Cottage } from '../model/cottage';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { CottageOwner } from '../model/cottageOwner';
import { Cottage1Service } from '../service/cottage1.service';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-add-cottage',
  templateUrl: './cottage-owner-add-cottage.component.html',
  styleUrls: ['./cottage-owner-add-cottage.component.css']
})
export class CottageOwnerAddCottageComponent implements OnInit {
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
  additionalItems: Array<AdditionalItem> = [];
  rules: Array<CottageBehavioralRules> = [];
  newAdditionalItem: AdditionalItem = new AdditionalItem({
    name: "",
    price: 0
  })
  newRule: CottageBehavioralRules = new CottageBehavioralRules({
    rule: ""
  })
  constructor(private http: HttpClient, private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private cottageService: Cottage1Service) { }

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

  addRule() {

    this.rules.push(this.newRule);
    this.newRule = new CottageBehavioralRules({
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
      this.cottage.mainPicture = this.selectedFile.name;
      this.cottage.items = this.additionalItems;
      this.cottage.rules = this.rules;
      this.route.params.subscribe(param => {
        this.id = param.id;
        this.cottageService.addCottage(this.id, this.cottage)
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
