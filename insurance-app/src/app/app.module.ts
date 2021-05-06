import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { HomeComponent } from 'src/nav/home.component';
import { NavBarComponent } from 'src/nav/nav-bar.component';
import { AdminPlansComponent } from 'src/policy/admin-plan.component';
import { CustomerPlansComponent } from 'src/policy/customer-plan.component';
import { AdminLoginComponent } from 'src/user/admin-login.component';
import { CustomerLoginComponent } from 'src/user/customer-login.component';
import { UserRegistrationComponent } from 'src/user/registration.component';
import {PolicyService} from 'src/services/policy.service';
import { AppComponent } from './app.component';
import { appRoutes } from './routes';
import { PolicyListAComponent } from 'src/policy/policy-list.component';
import { HttpClientModule } from '@angular/common/http';
import { PolicyListBComponent } from 'src/policy/admin-policy-list.component';
import { PolicyDetailsAComponent } from 'src/policy/policy-details.component';
import { PolicyDetailsBComponent } from 'src/policy/admin-policy-details.component';
import { UserService } from 'src/services/user.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService } from 'src/services/authenticate.service';
import { AddPolicyComponent } from 'src/policy/add-policy.component';
import { UserPolicyListComponent } from 'src/user-policies/user-policy-list.component';
import { UserPolicyService } from 'src/services/user-policy.service';
import { ViewUserPolicyComponent } from 'src/user-policies/view-user-policy.component';
import { UpdatePolicyComponent } from 'src/policy/update-policy.component';
import { UserAuthenticateService } from 'src/services/user-authenticate.service';
import { Error404Component } from 'src/error/error.component';
import { PortfolioComponent } from 'src/nav/portfolio.component';
import { AboutPageComponent } from 'src/nav/about.component';
import { ContactPageComponent } from 'src/nav/contact.component';
import { FilterPipe } from 'src/services/pipe.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ProfileComponent } from 'src/user/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    AdminLoginComponent,
    CustomerLoginComponent,
    UserRegistrationComponent,
    AdminPlansComponent,
    CustomerPlansComponent,
    PolicyListAComponent,
    PolicyListBComponent,
    PolicyDetailsAComponent,
    PolicyDetailsBComponent,
    AddPolicyComponent,
    UserPolicyListComponent,
    ViewUserPolicyComponent,
    UpdatePolicyComponent,
    Error404Component,
    PortfolioComponent,
    AboutPageComponent,
    ContactPageComponent,
    FilterPipe,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    Ng2SearchPipeModule
  
  ],
  providers: [PolicyService,UserService,
    AuthenticationService,UserPolicyService,
    UserAuthenticateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
