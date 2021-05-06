import { Routes } from "@angular/router";
import { Error404Component } from "src/error/error.component";
import { AboutPageComponent } from "src/nav/about.component";
import { ContactPageComponent } from "src/nav/contact.component";
import { HomeComponent } from "src/nav/home.component";
import { PortfolioComponent } from "src/nav/portfolio.component";
import { AddPolicyComponent } from "src/policy/add-policy.component";
import { AdminPlansComponent } from "src/policy/admin-plan.component";
import { PolicyDetailsBComponent } from "src/policy/admin-policy-details.component";
import { PolicyListBComponent } from "src/policy/admin-policy-list.component";
import { CustomerPlansComponent } from "src/policy/customer-plan.component";
import { PolicyDetailsAComponent } from "src/policy/policy-details.component";
import { PolicyListAComponent } from "src/policy/policy-list.component";
import { UpdatePolicyComponent } from "src/policy/update-policy.component";
import { UserPolicyListComponent } from "src/user-policies/user-policy-list.component";
import { ViewUserPolicyComponent } from "src/user-policies/view-user-policy.component";
import { AdminLoginComponent } from "src/user/admin-login.component";
import { CustomerLoginComponent } from "src/user/customer-login.component";
import { ProfileComponent } from "src/user/profile.component";
import { UserRegistrationComponent } from "src/user/registration.component";

export const appRoutes: Routes = [
 
    {path:'home',component:HomeComponent},
    {path: '', redirectTo: '/home', pathMatch: 'full' },
    {path:'admin', component:AdminLoginComponent},
    {path:'customer',component:CustomerLoginComponent},
    {path:'register',component:UserRegistrationComponent},
    {path:'adminplan',component:AdminPlansComponent},
    {path:'customerplan',component:CustomerPlansComponent},
    {path:'customerpolicylist',component:PolicyListAComponent},
    {path:'adminpolicylist',component:PolicyListBComponent},
    {path:'customerpolicy/:id',component:PolicyDetailsAComponent},
    {path:'adminpolicy/:id',component:PolicyDetailsBComponent},
    {path:'addpolicy',component:AddPolicyComponent},
    {path:'userpolicylist',component:UserPolicyListComponent},
    {path:'viewuserpolicy',component:ViewUserPolicyComponent},
    {path:'updatepolicy/:id',component:UpdatePolicyComponent},
    {path:'portfolio',component:PortfolioComponent},
    {path:'about',component:AboutPageComponent},
    {path:'contact',component:ContactPageComponent},
    {path:'profile',component:ProfileComponent},
    {path:'**',component:Error404Component}


   
   ]