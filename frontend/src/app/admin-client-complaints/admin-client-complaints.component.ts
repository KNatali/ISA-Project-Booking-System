import { AdminService } from './../service/admin.service';
import { AdventureComplaint } from './../model/adventureComplaint';
import { Component, OnInit } from '@angular/core';
import { BoatComplaint } from '../model/boatComplaint';
import { CottageComplaint } from '../model/cottageComplaint';

@Component({
  selector: 'app-admin-client-complaints',
  templateUrl: './admin-client-complaints.component.html',
  styleUrls: ['./admin-client-complaints.component.css']
})
export class AdminClientComplaintsComponent implements OnInit {
  adventureComplaints: AdventureComplaint[];
  boatComplaints:BoatComplaint[];
  cottageComplaints:CottageComplaint[];
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.getAdventureComplaints();
    this.getBoatComplaints();
  }

  getAdventureComplaints() {
    this.adminService.getAllAdventureComplaints()
      .subscribe(res => {
        this.adventureComplaints = res;
      })
  }

  getBoatComplaints() {
    this.adminService.getAllBoatComplaints()
      .subscribe(res => {
        this.boatComplaints = res;
      })
  }

  getCottageComplaints() {
    this.adminService.getAllCottageComplaints()
      .subscribe(res => {
        this.cottageComplaints = res;
      })
  }

  commentAdventure(answer: AdventureComplaint, id: any) {
    sessionStorage.setItem("adventureComplaint", JSON.stringify(answer));

    /*  this.adminService.rejectProfileDeleteRequests(request)
        .subscribe();*/
    this.adventureComplaints.forEach((request, index) => {
      if (request.id == id) this.adventureComplaints.splice(index, 1);
    });
  }

  commentBoat(answer: BoatComplaint, id: any) {
    sessionStorage.setItem("boatComplaint", JSON.stringify(answer));

    /*  this.adminService.rejectProfileDeleteRequests(request)
        .subscribe();*/
    this.boatComplaints.forEach((request, index) => {
      if (request.id == id) this.boatComplaints.splice(index, 1);
    });
  }

}
