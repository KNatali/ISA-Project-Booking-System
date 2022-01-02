import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-requests',
  templateUrl: './admin-requests.component.html',
  styleUrls: ['./admin-requests.component.css']
})
export class AdminRequestsComponent implements OnInit {
  activeTab: string = 'REGISTRATION';
  constructor() { }

  ngOnInit(): void {
  }
  changeTab(tabName: string) {
    this.activeTab = tabName;
  }
}
