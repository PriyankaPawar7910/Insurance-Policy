import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Policy } from "src/common/policy";
import { UserPolicy } from "src/common/user-policy";
import { PolicyService } from "src/services/policy.service";
import { UserAuthenticateService } from "src/services/user-authenticate.service";
import { UserPolicyService } from "src/services/user-policy.service";
@Component({
    selector:'view-user-policy',
    templateUrl:'./view-user-policy.component.html',
     styles: [`
     .thumbnail {min-height:210px;}
     .pad-left {margin-left:10px;}
     
     `]

})
export class ViewUserPolicyComponent implements OnInit{
    policies :Array<UserPolicy>
    click: boolean = false;
    constructor(private userPolicyService:UserPolicyService,
        private route:Router,private userAuthService:UserAuthenticateService){
        this.policies=[]

    }
    ngOnInit(){
        console.log(this.userAuthService.getUserId());
        this.userPolicyService.getUserPoliciesById(+this.userAuthService.getUserId()).subscribe(
            (policyList: UserPolicy[]) => {
            this.policies = policyList;
           console.log(this.policies)
          },
          error=>{
            console.error('Error!', error)
            alert("You don't have any bought policy!")
            this.route.navigateByUrl('/customerpolicylist');
          })
    }
    claimBtn(){
        this.click = !this.click;
        alert('Policy Claimed! Wait for response from our team');
        this.route.navigateByUrl('/customerpolicylist');
    }

}