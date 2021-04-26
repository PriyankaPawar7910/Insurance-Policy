import { DatePipe } from "@angular/common";
import { Component, Input } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { AddClaimPolicy } from "src/common/addclaim";
import { Policy } from "src/common/policy";
import { PolicyService } from "src/services/policy.service";
import { UserAuthenticateService } from "src/services/user-authenticate.service";
import { UserPolicyService } from "src/services/user-policy.service";

@Component({
  templateUrl: './policy-details.component.html',
  styles: [`
    .container {padding-left:20px; padding-right:20px;}
    .product-image {height:400px;}
    `],
    providers: [DatePipe]
})
export class PolicyDetailsAComponent {
  policy: Policy;
  claim : AddClaimPolicy={
    userId:undefined,
    policyId:undefined,
    claimedDate:undefined,
    status:undefined

  };
  click: boolean = false;
  myDate = new Date();


  constructor(private policyService: PolicyService,private datePipe:DatePipe,
    private route: ActivatedRoute, private userAuthService:UserAuthenticateService,
    private router:Router,private userPolicyService:UserPolicyService) {

  }
  ngOnInit() {
    this.policyService.getPolicy(+this.route.snapshot.params['id']).subscribe((policyInfo: Policy) => {
      this.policy = policyInfo;
    })
  }
  buyBtn(policyId:number){
    
    this.claim.userId = +this.userAuthService.getUserId();
    this.claim.policyId=policyId;
    this.claim.status=false;
    this.claim.claimedDate= this.datePipe.transform(this.myDate, 'yyyy-MM-dd');
    this.userPolicyService.claimPolicy(this.claim).subscribe(
      response=> {
        console.log('Success!', response)
        this.click = !this.click;
        alert("Successfuly added!")
      },
      error =>{
        console.error('Error!', error)
        alert("You have already taken this policy!")
      } )
    

  }



}