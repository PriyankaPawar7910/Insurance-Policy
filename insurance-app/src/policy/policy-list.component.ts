import { Component, OnInit } from "@angular/core";
import { Policy } from "src/common/policy";
import { PolicyService } from "src/services/policy.service";
@Component({
    selector:'policy-list',
    templateUrl:'./policy-list.component.html',
     styles: [`
     .thumbnail {min-height:210px;}
     .pad-left {margin-left:10px;}
     
     `]

})
export class PolicyListAComponent implements OnInit{
    policies :Array<Policy>
    searchText = '';
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