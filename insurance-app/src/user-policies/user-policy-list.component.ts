import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Policy } from "src/common/policy";
import { UserPolicy } from "src/common/user-policy";
import { PolicyService } from "src/services/policy.service";
import { UserPolicyService } from "src/services/user-policy.service";
@Component({
    selector:'user-policy-list',
    templateUrl:'./user-policy-list.component.html',
     styles: [`
     .thumbnail {min-height:100px;}
     .pad-left {margin-left:10px;}
     
     `]

})
export class UserPolicyListComponent implements OnInit{
    policies :Array<UserPolicy>
    userPolicies : Array<UserPolicy>
    click: boolean = false;
    constructor(private userPolicyService:UserPolicyService,private route:Router){
        this.policies=[]

    }
    ngOnInit(){
        this.userPolicyService.getUserPolicies().subscribe((policyList: UserPolicy[]) => {
            this.policies = policyList;
           console.log(this.policies)
          })
    }
    removeBtn(id){
        this.userPolicyService.removeUserPolicy(id).subscribe((policy:UserPolicy[]) =>{
            this.userPolicies = policy;
            this.click = !this.click;
            alert("Policy removed!");
            let currentUrl = this.route.url;
            this.route.routeReuseStrategy.shouldReuseRoute = () => false;
            this.route.onSameUrlNavigation = 'reload';
            this.route.navigate([currentUrl]);
        })
        

    }
    verifyBtn(){
        this.click = !this.click;
        alert('Policy Verified!');
    }

}