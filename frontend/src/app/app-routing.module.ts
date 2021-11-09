import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdventureListPageComponent } from './adventure-list-page/adventure-list-page.component';
import { BoatListPageComponent } from './boat-list-page/boat-list-page.component';
import { CottageListPageComponent } from './cottage-list-page/cottage-list-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';

const routes: Routes = [
  {path:'',component:MainPageComponent},
  {path:'sign-in', component:SignInPageComponent},
  {path:'register',component:RegisterPageComponent},
  {path:'cottages',component:CottageListPageComponent},
  {path:'boats',component:BoatListPageComponent},
  {path:'adventures',component:AdventureListPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
