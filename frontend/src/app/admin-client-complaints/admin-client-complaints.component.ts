import { AdminService } from './../service/admin.service';
import { AdventureComplaint } from './../model/adventureComplaint';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-client-complaints',
  templateUrl: './admin-client-complaints.component.html',
  styleUrls: ['./admin-client-complaints.component.css']
})
export class AdminClientComplaintsComponent implements OnInit {
  adventureComplaints: AdventureComplaint[];
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.getAdventureComplaints();
  }

  getAdventureComplaints() {
    this.adminService.getAllAdventureComplaints()
      .subscribe(res => {
        this.adventureComplaints = res;
      })
  }

   getBoatComplaints() {
    this.adminService.getAllAdventureComplaints()
      .subscribe(res => {
        this.adventureComplaints = res;
      })
  }

  getCottageComplaints() {
    this.adminService.getAllAdventureComplaints()
      .subscribe(res => {
        this.adventureComplaints = res;
      })
  }

  comment(answer: AdventureComplaint, id: any) {
    sessionStorage.setItem("adventureComplaint", JSON.stringify(answer));

    /*  this.adminService.rejectProfileDeleteRequests(request)
        .subscribe();*/
    this.adventureComplaints.forEach((request, index) => {
      if (request.id == id) this.adventureComplaints.splice(index, 1);
    });
  }

}
