import { Component, Input, OnInit } from '@angular/core';
import { Client } from '../model/client';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {
  @Input()
  client:Client;
  constructor() { }

  ngOnInit(): void {
  }

}
