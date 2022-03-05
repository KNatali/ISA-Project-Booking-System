import { AdminFirstLoginComponent } from './admin-first-login/admin-first-login.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { InstructorAddAdventureComponent } from './instructor-add-adventure/instructor-add-adventure.component';
import { InstructorAdventureProfileComponent } from './instructor-adventure-profile/instructor-adventure-profile.component';
import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdventureDatailsPageComponent } from './adventure-datails-page/adventure-datails-page.component';
import { AdventureListPageComponent } from './adventure-list-page/adventure-list-page.component';
import { BoatDetailsPageComponent } from './boat-details-page/boat-details-page.component';
import { BoatListPageComponent } from './boat-list-page/boat-list-page.component';
import { ClientPageComponent } from './client-page/client-page.component';
import { CottageDetailsPageComponent } from './cottage-details-page/cottage-details-page.component';
import { CottageListPageComponent } from './cottage-list-page/cottage-list-page.component';
import { CottageOwnerPageComponent } from './cottage-owner-page/cottage-owner-page.component';
import { InstructorPageComponent } from './instructor-page/instructor-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';

import { InstructorAdventureEditComponent } from './instructor-adventure-edit/instructor-adventure-edit.component';

import { ConfirmRegistrationClientComponent } from './confirm-registration-client/confirm-registration-client.component';
import { InstructorListComponent } from './instructor-list/instructor-list.component';
import { InstructorAdventureListComponent } from './instructor-adventure-list/instructor-adventure-list.component';

import { CottageReservationListComponent } from './cottage-reservation-list/cottage-reservation-list.component';
import { BoatReservationListComponent } from './boat-reservation-list/boat-reservation-list.component';
import { AdventureReservationListComponent } from './adventure-reservation-list/adventure-reservation-list.component';


import { InstructorReservationClientComponent } from './instructor-reservation-client/instructor-reservation-client.component';
import { InstructorAddReservationComponent } from './instructor-add-reservation/instructor-add-reservation.component';
import { InstructorActionAddComponent } from './instructor-action-add/instructor-action-add.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AdminAddAdminComponent } from './admin-add-admin/admin-add-admin.component';
import { CottageOwnerCottageProfileComponent } from './cottage-owner-cottage-profile/cottage-owner-cottage-profile.component';
import { CottageOwnerCottageEditComponent } from './cottage-owner-cottage-edit/cottage-owner-cottage-edit.component';
import { CottageOwnerAddCottageComponent } from './cottage-owner-add-cottage/cottage-owner-add-cottage.component';
import { CottageOwnerActionAddComponent } from './cottage-owner-action-add/cottage-owner-action-add.component';
import { CottageOwnerReservationClientComponent } from './cottage-owner-reservation-client/cottage-owner-reservation-client.component';
import { CottageOwnerAddReservationComponent } from './cottage-owner-add-reservation/cottage-owner-add-reservation.component';
import { BoatOwnerPageComponent } from './boat-owner-page/boat-owner-page.component';
import { BoatOwnerBoatProfileComponent } from './boat-owner-boat-profile/boat-owner-boat-profile.component';
import { BoatOwnerBoatEditComponent } from './boat-owner-boat-edit/boat-owner-boat-edit.component';
import { BoatOwnerReservationClientComponent } from './boat-owner-reservation-client/boat-owner-reservation-client.component';
import { BoatOwnerAddReservationComponent } from './boat-owner-add-reservation/boat-owner-add-reservation.component';
import { BoatOwnerActionAddComponent } from './boat-owner-action-add/boat-owner-action-add.component';
import { BoatOwnerAddBoatComponent } from './boat-owner-add-boat/boat-owner-add-boat.component';
import { RateIntructorComponent } from './rate-intructor/rate-intructor.component';


const routes: Routes = [
  { path: '', component: MainPageComponent },
  { path: 'sign-in', component: SignInPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'cottages', component: CottageListPageComponent },
  { path: 'boats', component: BoatListPageComponent },
  { path: 'intructors', component: InstructorListComponent },
  { path: 'adventures', component: AdventureListPageComponent },
  { path: 'instructors/:id', component: InstructorPageComponent },
  { path: 'clients/:id', component: ClientPageComponent },
  { path: 'admin/:id', component: AdminPageComponent },
  { path: 'admin/:id/admin-add', component: AdminAddAdminComponent },
  { path: 'first-login', component: AdminFirstLoginComponent },
  { path: 'cottageOwner/:id', component: CottageOwnerPageComponent },
  { path: 'boatOwner/:id', component: BoatOwnerPageComponent },
  { path: 'adventures/:id', component: AdventureDatailsPageComponent },
  { path: 'cottages/:id', component: CottageDetailsPageComponent },
  { path: 'boats/:id', component: BoatDetailsPageComponent },
  { path: 'client-profil', component: ClientPageComponent },
  { path: 'instructor/adventures/:id', component: InstructorAdventureProfileComponent },
  { path: 'instructor/adventures/edit/:id', component: InstructorAdventureEditComponent },
  { path: 'cottageOwner/cottages/:id', component: CottageOwnerCottageProfileComponent },
  { path: 'cottageOwner/cottages/edit/:id', component: CottageOwnerCottageEditComponent },
  { path: 'boatOwner/boats/:id', component: BoatOwnerBoatProfileComponent },
  { path: 'boatOwner/boats/edit/:id', component: BoatOwnerBoatEditComponent },
  { path: 'files', component: FileUploadComponent },
  { path: 'instructors/:id/adventure-add', component: InstructorAddAdventureComponent },
  { path: 'cottageOwner/:id/cottage-add', component: CottageOwnerAddCottageComponent },
  { path: 'boatOwner/:id/boat-add', component: BoatOwnerAddBoatComponent },
  { path: 'instructors/:id/action-add', component: InstructorActionAddComponent },
  { path: 'cottageOwner/:id/action-add', component: CottageOwnerActionAddComponent },
  { path: 'boatOwner/:id/action-add', component: BoatOwnerActionAddComponent },
  { path: 'confirm-registration/:id', component: ConfirmRegistrationClientComponent },
  { path: 'instructors/:id/reservation-add', component: InstructorAddReservationComponent },
  { path: 'cottageOwner/:id/reservation-add', component: CottageOwnerAddReservationComponent },
  { path: 'boatOwner/:id/reservation-add', component: BoatOwnerAddReservationComponent },


  { path: 'confirm-registration/:id', component: ConfirmRegistrationClientComponent },
  { path: 'instructor/reservations/:id', component: InstructorReservationClientComponent },
  { path: 'cottageOwner/reservations/:id', component: CottageOwnerReservationClientComponent },
  { path: 'boatOwner/reservations/:id', component: BoatOwnerReservationClientComponent },

  { path: 'instructors/adventures/client/:id', component: InstructorAdventureListComponent },
  { path: 'confirm-registration/:id', component: ConfirmRegistrationClientComponent },

  { path: 'history-cottage-reservations/:id', component: CottageReservationListComponent },
  { path: 'history-boat-reservations/:id', component: BoatReservationListComponent },
  { path: 'history-adventure-reservations/:id', component: AdventureReservationListComponent },

  { path: 'rate-instructor/:id',component: RateIntructorComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
