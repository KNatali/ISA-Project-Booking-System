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

  accept(revision: AdventureRevision, id: any) {
    this.adminService.acceptAdventureResvision(revision)
      .subscribe(res => {
        this.adventureRevisions.forEach((revision, index) => {
          if (revision.id == id) this.adventureRevisions.splice(index, 1);
        });
        alert("Successfully accepted revision! It will become public")
      }, error => {
        alert("Error! Please try again!");
      });

  }

  reject(revision: AdventureRevision, id: any) {
    this.adminService.rejectAdventureResvision(revision)
      .subscribe(res => {
        this.adventureRevisions.forEach((revision, index) => {
          if (revision.id == id) this.adventureRevisions.splice(index, 1);
        });
        alert("Successfully rejected revision!")
      }, error => {
        alert("Error! Please try again!");
      });
  }

}
