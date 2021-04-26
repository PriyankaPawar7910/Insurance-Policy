import { Component, Input } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Policy } from "src/common/policy";
import { UserPolicy } from "src/common/user-policy";
import { PolicyService } from "src/services/policy.service";
import { UserPolicyService } from "src/services/user-policy.service";

@Component({
  templateUrl: './admin-policy-details.component.html',
  styles: [`
    .container {padding-left:20px; padding-right:20px;}
    .product-image {height:400px;}
    `]
})
export class PolicyDetailsBComponent {
  policy: Policy;
  policies : Array<Policy>
  click: boolean = false;


  constructor(private policyService: PolicyService,private route: ActivatedRoute,
     private router:Router) {

  }
  ngOnInit() {
    this.policyService.getPolicy(+this.route.snapshot.params['id']).subscribe((policyInfo: Policy) => {
      this.policy = policyInfo;
    })
  }
  removeBtn(id){
    this.policyService.removePolicy(id).subscribe((policy:Policy[]) =>{
        this.policies = policy;
        this.click = !this.click;
        alert("Policy removed!");
        this.router.navigateByUrl('/adminpolicylist')
    })
    

}

editBtn(id){
  this.router.navigateByUrl(`/updatepolicy/${id}`);
}



}