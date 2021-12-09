import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-first-login',
  templateUrl: './admin-first-login.component.html',
  styleUrls: ['./admin-first-login.component.css']
})
export class AdminFirstLoginComponent implements OnInit {
  changePassword: boolean = false;
  id: any;
  newPassword: any;
  passwordConfirm: any;
  formV: FormGroup;
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
  submitPassword() {
    this.id = sessionStorage.getItem('id');
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

    this.changePassword = false;
    this.router.navigate(['/admin/:id']);
  }

}
