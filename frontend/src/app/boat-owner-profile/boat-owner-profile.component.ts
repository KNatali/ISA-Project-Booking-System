import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BoatOwner } from '../model/boatOwner';
import { BoatOwnerService } from '../service/boat-owner.service';

@Component({
  selector: 'app-boat-owner-profile',
  templateUrl: './boat-owner-profile.component.html',
  styleUrls: ['./boat-owner-profile.component.css']
})
export class BoatOwnerProfileComponent implements OnInit {
  profileShow: boolean = true;
  profileEdit: boolean = false;
  changePassword: boolean = false;
  oldPassword: any;
  newPassword: any;
  passwordConfirm: any;
  @Input() boatOwner: BoatOwner = new BoatOwner({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: '',
    state: '',
    mobile: ''
  });
  @Input() id: number;

  constructor(private boatOwnerService: BoatOwnerService, private route: ActivatedRoute
    , private router: Router) {
  }

  ngOnInit(): void {
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
    this.boatOwnerService.updateBoatOwner(this.id, this.boatOwner).subscribe(res => {
      this.goToProfilePage();
    })
  }

  submitPassword() {

    if ((this.newPassword != this.passwordConfirm))
      alert("New and confirmed password don't match!");
    else
      this.boatOwnerService.changePassword(this.id, this.newPassword).
        subscribe(res => {
          alert("password successfully changed!")
          this.goToProfilePage();
        })

  }
  goToProfilePage() {
    this.profileShow = true;
    this.profileEdit = false;
    this.changePassword = false;
    this.router.navigate(['/boatOwner/:id']);
  }
  close() {
    this.goToProfilePage();

  }

}
