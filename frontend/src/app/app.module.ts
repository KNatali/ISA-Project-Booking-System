import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
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
    AdventureDatailsPageComponent
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
    MatTabsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
