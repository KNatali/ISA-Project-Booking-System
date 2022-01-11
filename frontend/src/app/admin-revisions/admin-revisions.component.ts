import { Revision } from './../model/revision';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminService } from '../service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureRevision } from '../model/adventureRevision';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { EmailMessageService } from '../service/email-message.service';

@Component({
  selector: 'app-admin-revisions',
  templateUrl: './admin-revisions.component.html',
  styleUrls: ['./admin-revisions.component.css']
})
export class AdminRevisionsComponent implements OnInit {
  revisions: Revision[];
  adventureRevisions: AdventureRevision[];
  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService, private router: Router, private route: ActivatedRoute, private emailService: EmailMessageService) { }


  ngOnInit(): void {
    this.getAdventureRevidions();
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }


  getAdventureRevidions() {
    this.adminService.getAllAdventureRevisions()
      .subscribe(res => this.adventureRevisions = res);
  }

  accept(request: ProfileDeleteRequest, id: any) {
    /*this.adminService.acceptProfileDeleteRequests(request)
      .subscribe(res => {
        this.requests.forEach((request, index) => {
          if (request.id == id) this.requests.splice(index, 1);
        });
        alert("Successfully sent message to accepted user!")
      }, error => {
        alert("Error! Please try again!");
      });
*/
  }

  reject(request: ProfileDeleteRequest, id: any) {
    /*
        sessionStorage.setItem("profileDeleteRequest", JSON.stringify(request));
    
        this.requests.forEach((request, index) => {
          if (request.id == id) this.requests.splice(index, 1);
        });

        */
  }

}
