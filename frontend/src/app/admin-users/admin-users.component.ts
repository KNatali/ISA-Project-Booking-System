import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {
  users: User[];
  isSysAdmin: boolean = false;
  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") == "SysAdmin") {
      this.isSysAdmin = true;
    }

    this.getUsers();
  }

  getUsers() {
    this.adminService.getAllUsers()
      .subscribe(res => this.users = res);
  }

  deleteUser(id: number) {
    this.adminService.deleteUser(id)
      .subscribe(data => {
        alert('Succesfully deleted! ')
        window.location.reload();
      }, error => {
        alert('Error')
      });

  }



}
