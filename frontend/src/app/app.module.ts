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
import { NgChartsModule } from 'ng2-charts';
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

import { InstructorReservationClientComponent } from './instructor-reservation-client/instructor-reservation-client.component';
import { InstructorAddReservationComponent } from './instructor-add-reservation/instructor-add-reservation.component';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { InstructorOverviewComponent } from './instructor-overview/instructor-overview.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { InstructorActionsComponent } from './instructor-actions/instructor-actions.component';
import { InstructorActionAddComponent } from './instructor-action-add/instructor-action-add.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';
import { AdminAddAdminComponent } from './admin-add-admin/admin-add-admin.component';

import { AdminEntitiesComponent } from './admin-entities/admin-entities.component';
import { AdminReservationRequestsComponent } from './admin-reservation-requests/admin-reservation-requests.component';
import { AdminOverviewComponent } from './admin-overview/admin-overview.component';

import { FileUploadComponent } from './file-upload/file-upload.component';
import { AdminFirstLoginComponent } from './admin-first-login/admin-first-login.component';

import { AvailableBoatTermsListComponent } from './available-boat-terms-list/available-boat-terms-list.component';
import { AvailableBoatTermsItemComponent } from './available-boat-terms-item/available-boat-terms-item.component';
import { AdditionalItemBoatListComponent } from './additional-item-boat-list/additional-item-boat-list.component';
import { AdditionalItemBoatItemComponent } from './additional-item-boat-item/additional-item-boat-item.component';

import { CottageOwnerAddCottageComponent } from './cottage-owner-add-cottage/cottage-owner-add-cottage.component';
import { CottageAdditionItemsEditComponent } from './cottage-addition-items-edit/cottage-addition-items-edit.component';
import { CottageCardComponent } from './cottage-card/cottage-card.component';
import { CottageRulesEditComponent } from './cottage-rules-edit/cottage-rules-edit.component';
import { CottageOwnerReservationClientComponent } from './cottage-owner-reservation-client/cottage-owner-reservation-client.component';
import { CottageOwnerReservationsComponent } from './cottage-owner-reservations/cottage-owner-reservations.component';
import { CottageOwnerOverviewComponent } from './cottage-owner-overview/cottage-owner-overview.component';
import { CottageOwnerCottagesComponent } from './cottage-owner-cottages/cottage-owner-cottages.component';
import { CottageOwnerActionsComponent } from './cottage-owner-actions/cottage-owner-actions.component';
import { CottageOwnerActionAddComponent } from './cottage-owner-action-add/cottage-owner-action-add.component';
import { CottageOwnerAddReservationComponent } from './cottage-owner-add-reservation/cottage-owner-add-reservation.component';
import { CottageOwnerCottageEditComponent } from './cottage-owner-cottage-edit/cottage-owner-cottage-edit.component';
import { CottageOwnerCottageListComponent } from './cottage-owner-cottage-list/cottage-owner-cottage-list.component';
import { CottageOwnerCottageProfileComponent } from './cottage-owner-cottage-profile/cottage-owner-cottage-profile.component';
import { CottageOwnerChangePasswordComponent } from './cottage-owner-change-password/cottage-owner-change-password.component';
import { CottageOwnerItemComponent } from './cottage-owner-item/cottage-owner-item.component';
import { CottageOwnerListComponent } from './cottage-owner-list/cottage-owner-list.component';
import { SortOwnersComponent } from './sort-owners/sort-owners.component';


import { InstructorNavbarComponent } from './instructor-navbar/instructor-navbar.component';
import { InstructorReservationReportComponent } from './instructor-reservation-report/instructor-reservation-report.component';
import { InstructorDeleteProfileComponent } from './instructor-delete-profile/instructor-delete-profile.component';
import { AdminRejectRequestComponent } from './admin-reject-request/admin-reject-request.component';
import { AdminRequestsComponent } from './admin-requests/admin-requests.component';
import { AdminProfileDeleteRequestsComponent } from './admin-profile-delete-requests/admin-profile-delete-requests.component';
import { InstructorActiveReservationsComponent } from './instructor-active-reservations/instructor-active-reservations.component';
import { InstructorUpcomingReservationsComponent } from './instructor-upcoming-reservations/instructor-upcoming-reservations.component';
import { InstructorCompletedReservationsComponent } from './instructor-completed-reservations/instructor-completed-reservations.component';
import { AdminReservationReportsComponent } from './admin-reservation-reports/admin-reservation-reports.component';
import { CottageOwnerActiveReservationsComponent } from './cottage-owner-active-reservations/cottage-owner-active-reservations.component';
import { CottageOwnerUpcomingReservationsComponent } from './cottage-owner-upcoming-reservations/cottage-owner-upcoming-reservations.component';
import { CottageOwnerCompletedReservationsComponent } from './cottage-owner-completed-reservations/cottage-owner-completed-reservations.component';
import { AdminEarningsComponent } from './admin-earnings/admin-earnings.component';
import { AdminAnalyticsComponent } from './admin-analytics/admin-analytics.component';
import { InstructorCalendarComponent } from './instructor-calendar/instructor-calendar.component';
import { InstructorAnalyticsComponent } from './instructor-analytics/instructor-analytics.component';
import { BoatOwnerCalendarComponent } from './boat-owner-calendar/boat-owner-calendar.component';
import { BoatOwnerAnalyticsComponent } from './boat-owner-analytics/boat-owner-analytics.component';
import { AdminClientComplaintsComponent } from './admin-client-complaints/admin-client-complaints.component';
import { AdminComplaintAnswerComponent } from './admin-complaint-answer/admin-complaint-answer.component';
import { BoatOwnerPageComponent } from './boat-owner-page/boat-owner-page.component';
import { BoatOwnerOverviewComponent } from './boat-owner-overview/boat-owner-overview.component';
import { BoatOwnerProfileComponent } from './boat-owner-profile/boat-owner-profile.component';
import { BoatOwnerBoatsComponent } from './boat-owner-boats/boat-owner-boats.component';
import { BoatOwnerReservationsComponent } from './boat-owner-reservations/boat-owner-reservations.component';
import { BoatOwnerActionsComponent } from './boat-owner-actions/boat-owner-actions.component';
import { BoatOwnerReservationReportComponent } from './boat-owner-reservation-report/boat-owner-reservation-report.component';
import { BoatOwnerDeleteProfileComponent } from './boat-owner-delete-profile/boat-owner-delete-profile.component';
import { BoatOwnerActiveReservationsComponent } from './boat-owner-active-reservations/boat-owner-active-reservations.component';
import { BoatOwnerUpcomingReservationsComponent } from './boat-owner-upcoming-reservations/boat-owner-upcoming-reservations.component';
import { BoatOwnerCompletedReservationsComponent } from './boat-owner-completed-reservations/boat-owner-completed-reservations.component';
import { CottageOwnerReservationReportComponent } from './cottage-owner-reservation-report/cottage-owner-reservation-report.component';
import { CottageOwnerDeleteProfileComponent } from './cottage-owner-delete-profile/cottage-owner-delete-profile.component';
import { CottageOwnerCalendarComponent } from './cottage-owner-calendar/cottage-owner-calendar.component';
import { CottageOwnerAnalyticsComponent } from './cottage-owner-analytics/cottage-owner-analytics.component';
import { AdminRevisionsComponent } from './admin-revisions/admin-revisions.component';
import { BoatOwnerChangePasswordComponent } from './boat-owner-change-password/boat-owner-change-password.component';
import { BoatOwnerBoatProfileComponent } from './boat-owner-boat-profile/boat-owner-boat-profile.component';
import { BoatOwnerBoatEditComponent } from './boat-owner-boat-edit/boat-owner-boat-edit.component';
import { BoatAdditionItemsEditComponent } from './boat-addition-items-edit/boat-addition-items-edit.component';
import { BoatNavigationEquipmentEditComponent } from './boat-navigation-equipment-edit/boat-navigation-equipment-edit.component';
import { BoatOwnerReservationClientComponent } from './boat-owner-reservation-client/boat-owner-reservation-client.component';
import { BoatOwnerAddReservationComponent } from './boat-owner-add-reservation/boat-owner-add-reservation.component';



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
    SubscribeItemComponent,

    InstructorReservationClientComponent,
    InstructorAddReservationComponent,
    InstructorOverviewComponent,
    InstructorActionsComponent,
    InstructorActionAddComponent,
    AdminPageComponent,
    AdminProfileComponent,
    AdminUsersComponent,
    AdminAddAdminComponent,
    AdminEntitiesComponent,
    AdminReservationRequestsComponent,
    AdminOverviewComponent,

    FileUploadComponent,
    AdminFirstLoginComponent,

    AvailableBoatTermsListComponent,
    AvailableBoatTermsItemComponent,
    AdditionalItemBoatListComponent,
    AdditionalItemBoatItemComponent,

    CottageOwnerAddCottageComponent,
    CottageAdditionItemsEditComponent,
    CottageCardComponent,
    CottageRulesEditComponent,
    CottageOwnerReservationClientComponent,
    CottageOwnerReservationsComponent,
    CottageOwnerOverviewComponent,
    CottageOwnerCottagesComponent,
    CottageOwnerActionsComponent,
    CottageOwnerActionAddComponent,
    CottageOwnerAddReservationComponent,
    CottageOwnerCottageEditComponent,
    CottageOwnerCottageListComponent,
    CottageOwnerCottageProfileComponent,
    CottageOwnerChangePasswordComponent,
    CottageOwnerItemComponent,
    CottageOwnerListComponent,
    SortOwnersComponent,

    InstructorNavbarComponent,
    InstructorReservationReportComponent,
    InstructorDeleteProfileComponent,
    AdminRejectRequestComponent,
    AdminRequestsComponent,
    AdminProfileDeleteRequestsComponent,
    InstructorActiveReservationsComponent,
    InstructorUpcomingReservationsComponent,
    InstructorCompletedReservationsComponent,
    AdminReservationReportsComponent,
    CottageOwnerActiveReservationsComponent,
    CottageOwnerUpcomingReservationsComponent,
    CottageOwnerCompletedReservationsComponent,
    AdminEarningsComponent,
    AdminAnalyticsComponent,
    InstructorCalendarComponent,
    InstructorAnalyticsComponent,
    BoatOwnerCalendarComponent,
    BoatOwnerAnalyticsComponent,
    AdminClientComplaintsComponent,
    AdminComplaintAnswerComponent,
    BoatOwnerPageComponent,
    BoatOwnerOverviewComponent,
    BoatOwnerProfileComponent,
    BoatOwnerBoatsComponent,
    BoatOwnerReservationsComponent,
    BoatOwnerActionsComponent,
    BoatOwnerReservationReportComponent,
    BoatOwnerDeleteProfileComponent,
    BoatOwnerActiveReservationsComponent,
    BoatOwnerUpcomingReservationsComponent,
    BoatOwnerCompletedReservationsComponent,
    CottageOwnerReservationReportComponent,
    CottageOwnerDeleteProfileComponent,
    CottageOwnerCalendarComponent,
    CottageOwnerAnalyticsComponent,
    AdminRevisionsComponent,
    BoatOwnerChangePasswordComponent,
    BoatOwnerBoatProfileComponent,
    BoatOwnerBoatEditComponent,
    BoatAdditionItemsEditComponent,
    BoatNavigationEquipmentEditComponent,
    BoatOwnerReservationClientComponent,
    BoatOwnerAddReservationComponent




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
    NgChartsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),

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
