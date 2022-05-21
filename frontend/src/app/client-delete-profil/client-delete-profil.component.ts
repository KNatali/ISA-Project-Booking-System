import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { ProfileDeleteRequestType } from '../model/profileDeleteRequestType';
import { User } from '../model/user';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-client-delete-profil',
  templateUrl: './client-delete-profil.component.html',
  styleUrls: ['./client-delete-profil.component.css']
})
export class ClientDeleteProfilComponent implements OnInit {
  reason_text:string;
  id:number;
  newUser: User = new User({
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
    role: '',
    firstLogin: false
  });
  request: ProfileDeleteRequest = new ProfileDeleteRequest({
    id: 0,
    userDTO: this.newUser,
    reason: '',
    type: ProfileDeleteRequestType.Unverified
  });

  constructor(private route: ActivatedRoute,
              private clientService:ClientService        
    ) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData(){
    this.route.params.subscribe(param => {
      this.id = param.id;
    });
  }
  sendDeleteRequest(){
    this.request.reason = this.reason_text;
    this.request.userDTO.id = this.id;
    this.clientService.save(this.request).subscribe();
  }
}
