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
import { ConfirmRegistrationClientComponent } from './confirm-registration-client/confirm-registration-client.component';
import { InstructorListComponent } from './instructor-list/instructor-list.component';

const routes: Routes = [
  { path: '', component: MainPageComponent },
  { path: 'sign-in', component: SignInPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'cottages', component: CottageListPageComponent },
  { path: 'boats', component: BoatListPageComponent },
  { path: 'intructors',component:InstructorListComponent},
  { path: 'adventures', component: AdventureListPageComponent },
  { path: 'instructors/:id', component: InstructorPageComponent },
  { path: 'clients/:id', component: ClientPageComponent},
  { path: 'cottageOwner/:id', component: CottageOwnerPageComponent },
  { path: 'adventures/:id', component: AdventureDatailsPageComponent },
  { path: 'cottages/:id', component: CottageDetailsPageComponent },
  { path: 'boats/:id', component: BoatDetailsPageComponent },
  { path: 'client-profil', component: ClientPageComponent },
  { path: 'instructor/adventures/:id', component: InstructorAdventureProfileComponent },
  { path: 'confirm-registration/:id',component:ConfirmRegistrationClientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
