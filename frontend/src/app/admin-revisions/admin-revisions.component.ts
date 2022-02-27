import { Revision } from './../model/revision';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminService } from '../service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureRevision } from '../model/adventureRevision';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { EmailMessageService } from '../service/email-message.service';
import { BoatRevision } from '../model/boatRevision';
import { CottageRevision } from '../model/cottageRevision';

@Component({
  selector: 'app-admin-revisions',
  templateUrl: './admin-revisions.component.html',
  styleUrls: ['./admin-revisions.component.css']
})
export class AdminRevisionsComponent implements OnInit {
  revisions: Revision[];
  adventureRevisions: AdventureRevision[];
  boatRevisions: BoatRevision[];
  cottageRevisions: CottageRevision[];
  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private adminService: AdminService, private router: Router, private route: ActivatedRoute, private emailService: EmailMessageService) { }


  ngOnInit(): void {
    this.getAdventureRevisions();
    this.getBoatRevisions();
    this.getCottageRevisions();
    this.formValue = this.formBuilder.group({
      message: [''],

    })
  }


  getAdventureRevisions() {
    this.adminService.getAllAdventureRevisions()
      .subscribe(res => this.adventureRevisions = res);
  }

  getBoatRevisions() {
    this.adminService.getAllBoatRevisions()
      .subscribe(res => this.boatRevisions = res);
  }

  getCottageRevisions() {
    this.adminService.getAllCottageRevisions()
      .subscribe(res => this.cottageRevisions = res);
  }

  acceptAdventure(revision: AdventureRevision, id: any) {
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

  rejectAdventure(revision: AdventureRevision, id: any) {
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

  acceptBoat(revision: BoatRevision, id: any) {
    this.adminService.acceptBoatResvision(revision)
      .subscribe(res => {
        this.boatRevisions.forEach((revision, index) => {
          if (revision.id == id) this.boatRevisions.splice(index, 1);
        });
        alert("Successfully accepted revision! It will become public")
      }, error => {
        alert("Error! Please try again!");
      });

  }

  rejectBoat(revision: BoatRevision, id: any) {
    this.adminService.rejectBoatResvision(revision)
      .subscribe(res => {
        this.boatRevisions.forEach((revision, index) => {
          if (revision.id == id) this.boatRevisions.splice(index, 1);
        });
        alert("Successfully rejected revision!")
      }, error => {
        alert("Error! Please try again!");
      });
  }

  acceptCottage(revision: CottageRevision, id: any) {
    this.adminService.acceptCottageResvision(revision)
      .subscribe(res => {
        this.cottageRevisions.forEach((revision, index) => {
          if (revision.id == id) this.cottageRevisions.splice(index, 1);
        });
        alert("Successfully accepted revision! It will become public")
      }, error => {
        alert("Error! Please try again!");
      });

  }

  rejectCottage(revision: CottageRevision, id: any) {
    this.adminService.rejectCottageResvision(revision)
      .subscribe(res => {
        this.cottageRevisions.forEach((revision, index) => {
          if (revision.id == id) this.cottageRevisions.splice(index, 1);
        });
        alert("Successfully rejected revision!")
      }, error => {
        alert("Error! Please try again!");
      });
  }

}
