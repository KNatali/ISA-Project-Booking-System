import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CottageOwner } from '../model/cottageOwner';
import { CottageOwnerService } from '../service/cottageOwner.service';

@Component({
  selector: 'app-cottage-owner-profile',
  templateUrl: './cottage-owner-profile.component.html',
  styleUrls: ['./cottage-owner-profile.component.css']
})
export class CottageOwnerProfileComponent implements OnInit {
  profileShow: boolean = true;
  profileEdit: boolean = false;
  @Input() cottageOwner: CottageOwner = new CottageOwner({
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    address: '',
    city: '',
    state: '',
    mobile: ''

  });
  @Input() id: number;

  constructor(private cottageOwnerService: CottageOwnerService, private route: ActivatedRoute
    , private router: Router) { }

  ngOnInit(): void {
  }
  edit() {
    this.profileShow = !this.profileShow;
    this.profileEdit = !this.profileEdit;

  }
  submit() {
    this.cottageOwnerService.updateCottageOwner(this.id, this.cottageOwner).subscribe(res => {
      this.goToProfilePage();
    })
  }
  goToProfilePage() {
    this.profileShow = true;
    this.profileEdit = false;

    this.router.navigate(['/cottageOwner/:id']);
  }
  close() {
    window.location.reload();

  }

}
