import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../model/admin';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-add-admin',
  templateUrl: './admin-add-admin.component.html',
  styleUrls: ['./admin-add-admin.component.css']
})
export class AdminAddAdminComponent implements OnInit {
  id: any;
  confirmedPassword: '';
  formValue!: FormGroup;
  admin: User = new User({
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
    role: 'Admin',
    firstLogin: true
  });

  constructor(private adminService: AdminService, private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      email: [''],
      state: [''],
      city: [''],
      street: [''],
      mobile: [''],
      username: [''],
      password: [''],
      confirmedPassword: ['']

    })

  }

  addAdmin() {
    if (this.admin.password == this.confirmedPassword) {

      this.adminService.addNewAdmin(this.admin)
        .subscribe(data => {

          alert("Successfully added new admin");
          this.router.navigate(['']);
        }, error => {
          alert(error)
        });
    } else {
      alert("Password and confirmed password don't match!");
    }
  }

}
