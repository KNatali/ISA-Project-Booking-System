import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../model/admin';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {
  id: any;
  admin: Admin = new Admin({
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
  constructor(private route: ActivatedRoute, private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem("id");
    this.getById();

  }
  getById() {
    this.adminService.getById(this.id)
      .subscribe(res => {
        this.admin = res;

        if (this.admin.firstLogin == true) {
          this.router.navigate(['first-login']);
        }


      })
  }

}
