import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../model/admin';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
  profileShow: boolean = true;
  profileEdit: boolean = false;
  changePassword: boolean = false;

  newPassword: any;
  passwordConfirm: any;
  formV: FormGroup;
  @Input() admin: Admin = new Admin({
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
    biography: '',
    firstLogin: false


  });
  @Input() id: number;
  constructor(private adminService: AdminService, private route: ActivatedRoute
    , private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.formV = this.fb.group({

      newPassword: ['', Validators.required],
      passwordConfirm: ['', Validators.required]

    }

    );
  }
  get registerFormControl() {
    return this.formV.controls;
  }
  edit() {
    this.profileShow = !this.profileShow;
    this.profileEdit = !this.profileEdit;
    this.changePassword = false;

  }
  change() {
    this.profileShow = false;
    this.profileEdit = false;
    this.changePassword = true;
  }
  submit() {
    this.adminService.updateAdmin(this.id, this.admin).subscribe(res => {
      this.goToProfilePage();
    })
  }

  submitPassword() {
    if (this.formV.valid) {

      if ((this.newPassword != this.passwordConfirm))
        alert("New and confirmed password don't match!");
      else
        this.adminService.changePassword(this.id, this.newPassword).
          subscribe(res => {
            alert("password successfully changed!")
            this.goToProfilePage();
          })

    }
    else
      alert("Fill the required fields!");

  }
  goToProfilePage() {
    this.profileShow = true;
    this.profileEdit = false;
    this.changePassword = false;
    this.router.navigate(['/admin/:id']);
  }
  close() {
    this.goToProfilePage();

  }

}
