import { Component, Input, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {
  @Input()
  client:Client;
  newPassword1:string;
  newPassword2:string;
  error:string;
  editedClient: Client = new Client({
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
  edit_form_available:boolean;
  profil_info_available:boolean;
  change_password_available:boolean;
  sta:string;
  constructor(private clientService:ClientService) { 
    this.edit_form_available=false;
    this.profil_info_available=true;
    this.change_password_available=false;
    this.newPassword2="";
    this.newPassword1="";
    //this.editedClient=this.client;
  }

  ngOnInit(): void {
  }
  EditProfil(){
    this.edit_form_available=true;
    this.profil_info_available=false;
    this.change_password_available=false;
    this.editedClient=this.client;
  }
  ChangeInfo(){
    this.profil_info_available=true;
    this.edit_form_available=false;
    this.change_password_available=false;
    this.client=this.editedClient;
    this.clientService.updateClient(this.editedClient)
    .subscribe()
  }
  ChangePassword(){
    this.profil_info_available=false;
    this.change_password_available=true;
  }
  SubmitChangePassword(){
    if(this.newPassword1!=this.newPassword2){
      this.error="passwords are not equal, try again";
    }else{
      this.profil_info_available=true;
      this.change_password_available=false;
      this.client.password=this.newPassword1;
      this.clientService.changePassword(this.client)
      .subscribe();
    }

  }
}
