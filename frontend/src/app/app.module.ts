import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from "@angular/common";
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AppRoutingModule } from './app-routing.module';
import { MatTabsModule } from '@angular/material/tabs';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { CottageListPageComponent } from './cottage-list-page/cottage-list-page.component';
import { BoatListPageComponent } from './boat-list-page/boat-list-page.component';
import { AdventureListPageComponent } from './adventure-list-page/adventure-list-page.component';
import { BoatListItemComponent } from './boat-list-item/boat-list-item.component';
import { CottageListItemComponent } from './cottage-list-item/cottage-list-item.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AdventureListItemComponent } from './adventure-list-item/adventure-list-item.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdventureCardComponent } from './adventure-card/adventure-card.component';
import { InstructorProfileComponent } from './instructor-profile/instructor-profile.component';
import { InstructorPageComponent } from './instructor-page/instructor-page.component';
import { CottageDetailsPageComponent } from './cottage-details-page/cottage-details-page.component';
import { AdventureDatailsPageComponent } from './adventure-datails-page/adventure-datails-page.component';
import { BoatDetailsPageComponent } from './boat-details-page/boat-details-page.component';
import { SearchCottageComponent } from './search-cottage/search-cottage.component';



//import { LightgalleryModule } from 'lightgallery/angular';

import { InstructorAdventuresComponent } from './instructor-adventures/instructor-adventures.component';

import { SearchBoatComponent } from './search-boat/search-boat.component';
import { SearchAdventureComponent } from './search-adventure/search-adventure.component';
import { ClientPageComponent } from './client-page/client-page.component';
import { ClientProfileComponent } from './client-profile/client-profile.component';
import { CottageOwnerPageComponent } from './cottage-owner-page/cottage-owner-page.component';
import { CottageOwnerProfileComponent } from './cottage-owner-profile/cottage-owner-profile.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatLabel } from '@angular/material/form-field';
import { MatFormField } from '@angular/material/form-field';
import { NavbarLoginComponent } from './navbar-login/navbar-login.component';
import { NavbarProfileComponent } from './navbar-profile/navbar-profile.component';
import { UserService } from './service/user.service';
import { TokenInterceptor } from './interceptor/TokenInterceptor';
import { InstructorAdventureProfileComponent } from './instructor-adventure-profile/instructor-adventure-profile.component';

import { InstructorAdventureEditComponent } from './instructor-adventure-edit/instructor-adventure-edit.component';
import { AdventureEquipmentEditComponent } from './adventure-equipment-edit/adventure-equipment-edit.component';
import { AdventureAdditionalItemsEditComponent } from './adventure-additional-items-edit/adventure-additional-items-edit.component';
import { AdventureRulesEditComponent } from './adventure-rules-edit/adventure-rules-edit.component';
import { InstructorAddAdventureComponent } from './instructor-add-adventure/instructor-add-adventure.component';

import { ConfirmRegistrationClientComponent } from './confirm-registration-client/confirm-registration-client.component';
import { SortBoatsComponent } from './sort-boats/sort-boats.component';
import { SortCottagesComponent } from './sort-cottages/sort-cottages.component';
import { InstructorListComponent } from './instructor-list/instructor-list.component';
import { InstructorItemComponent } from './instructor-item/instructor-item.component';
import { SortInstructorsComponent } from './sort-instructors/sort-instructors.component';

import { InstructorReservationsComponent } from './instructor-reservations/instructor-reservations.component';
import { InstructorChangePasswordComponent } from './instructor-change-password/instructor-change-password.component';

import { InstructorAdventureListComponent } from './instructor-adventure-list/instructor-adventure-list.component';
import { CottageReservationListComponent } from './cottage-reservation-list/cottage-reservation-list.component';
import { CottageReservationItemComponent } from './cottage-reservation-item/cottage-reservation-item.component';
import { SortCottageReservationsComponent } from './sort-cottage-reservations/sort-cottage-reservations.component';
import { BoatReservationItemComponent } from './boat-reservation-item/boat-reservation-item.component';
import { BoatReservationListComponent } from './boat-reservation-list/boat-reservation-list.component';
import { SortBoatReservationsComponent } from './sort-boat-reservations/sort-boat-reservations.component';
import { AdventureReservationListComponent } from './adventure-reservation-list/adventure-reservation-list.component';
import { AdvetureReservationItemComponent } from './adveture-reservation-item/adveture-reservation-item.component';
import { SortAdventureReservationComponent } from './sort-adventure-reservation/sort-adventure-reservation.component';
import { ActiveReservationsComponent } from './active-reservations/active-reservations.component';
import { ActiveBoatReservationComponent } from './active-boat-reservation/active-boat-reservation.component';
import { ActiveCottageReservationComponent } from './active-cottage-reservation/active-cottage-reservation.component';
import { ActiveAdventureReservationComponent } from './active-adventure-reservation/active-adventure-reservation.component';
import { ComplaintFormComponent } from './complaint-form/complaint-form.component';
import { SubscribeItemsListComponent } from './subscribe-items-list/subscribe-items-list.component';
import { SubscribeItemComponent } from './subscribe-item/subscribe-item.component';



@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    SignInPageComponent,
    RegisterPageComponent,
    CottageListPageComponent,
    BoatListPageComponent,
    AdventureListPageComponent,
    BoatListItemComponent,
    CottageListItemComponent,
    AdventureListItemComponent,
    AdventureCardComponent,
    InstructorProfileComponent,
    InstructorPageComponent,
    CottageDetailsPageComponent,
    AdventureDatailsPageComponent,
    BoatDetailsPageComponent,
    SearchCottageComponent,

    InstructorAdventuresComponent,

    SearchBoatComponent,
    SearchAdventureComponent,
    ClientPageComponent,

    ClientProfileComponent,
    CottageOwnerPageComponent,
    CottageOwnerProfileComponent,
    NavbarComponent,
    NavbarLoginComponent,
    NavbarProfileComponent,
    InstructorAdventureProfileComponent,

    InstructorAdventureEditComponent,
    AdventureEquipmentEditComponent,
    AdventureAdditionalItemsEditComponent,
    AdventureRulesEditComponent,
    InstructorAddAdventureComponent,

    ConfirmRegistrationClientComponent,
    SortBoatsComponent,
    SortCottagesComponent,
    InstructorListComponent,
    InstructorItemComponent,
    SortInstructorsComponent,

    InstructorReservationsComponent,
    InstructorChangePasswordComponent,

    InstructorAdventureListComponent,
    CottageReservationListComponent,
    CottageReservationItemComponent,
    SortCottageReservationsComponent,
    BoatReservationItemComponent,
    BoatReservationListComponent,
    SortBoatReservationsComponent,
    AdventureReservationListComponent,
    AdvetureReservationItemComponent,
    SortAdventureReservationComponent,
    ActiveReservationsComponent,
    ActiveBoatReservationComponent,
    ActiveCottageReservationComponent,
    ActiveAdventureReservationComponent,
    ComplaintFormComponent,
    SubscribeItemsListComponent,
    SubscribeItemComponent



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatTabsModule,
    MatFormFieldModule,
    ReactiveFormsModule

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
