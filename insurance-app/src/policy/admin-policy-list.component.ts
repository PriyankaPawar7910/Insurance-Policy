import { Component, OnInit } from "@angular/core";
import { Policy } from "src/common/policy";
import { PolicyService } from "src/services/policy.service";
@Component({
    selector:'admin-policy-list',
    templateUrl:'./admin-policy-list.component.html',
     styles: [`
     .thumbnail {min-height:210px;}
     .pad-left {margin-left:10px;}
     
     `]

})
export class PolicyListBComponent implements OnInit{
    searchText = '';
    policies :Array<Policy>
    constructor(private policyService : PolicyService){
        this.policies=[]

    }
    ngOnInit(){
        this.policyService.getAllPolicies().subscribe((policyList: Policy[]) => {
            this.policies = policyList;
           console.log(this.policies)
          })
    }

}