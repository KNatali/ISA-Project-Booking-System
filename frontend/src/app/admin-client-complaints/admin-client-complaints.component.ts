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
    this.getCottageComplaints();
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
    sessionStorage.setItem("complaint", JSON.stringify({type:"Adventure",id:answer.id,ownerId:answer.adventure.instructor.id,clientId:answer.client.id}));

    /*  this.adminService.rejectProfileDeleteRequests(request)
        .subscribe();*/
  }

  commentBoat(answer: BoatComplaint, id: any) {
    sessionStorage.setItem("complaint", JSON.stringify({type:"Boat",id:answer.id,ownerId:answer.boat.boat.boatOwner.id,clientId:answer.client.id}));

    /*  this.adminService.rejectProfileDeleteRequests(request)
        .subscribe();*/
   
  }
  commentCottage(answer: CottageComplaint, id: any) {
    sessionStorage.setItem("complaint", JSON.stringify({type:"Cottage",id:answer.id,ownerId:answer.cottage.cottage.cottageOwner.id,clientId:answer.client.id}));

    /*  this.adminService.rejectProfileDeleteRequests(request)
        .subscribe();*/
   
  }

}
