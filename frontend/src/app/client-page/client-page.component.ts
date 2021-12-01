import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit {
  client: Client = new Client({
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
  id:number;

  constructor(private clientService: ClientService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadClient();
  }
  loadClient(){
    this.id = this.route.snapshot.params['id'];
    this.clientService.getById(this.id)
      .subscribe(res => this.client = res)
  }

}
