import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { PolicyService } from "src/services/policy.service";
import { UserService } from "src/services/user.service";

@Component({
    selector:'add-policy',
    templateUrl:'./add-policy.component.html'
})
export class AddPolicyComponent{
    policyForm: FormGroup;
    policyList: any = ['Individual Coverage', 'Family Coverage', 'Critical Illness Coverage'
    ,'Accidental Coverage','Installment Coverage','No Age Limit Coverage']

    constructor(private route: Router, private formBuilder: FormBuilder, private policyService:PolicyService) {

    }
    ngOnInit() {
        this.policyForm = this.formBuilder.group({
            policyName: ['', [Validators.required, Validators.minLength(3)]],
            policyDescription: ['', [Validators.required, Validators.minLength(5)]],
            policyType: ['', [Validators.required]],
            premiumAmount: ['', [Validators.required, Validators.minLength(5)]],
            duration: ['', [Validators.required,Validators.minLength(1)]],


        });
    }
    get policyName() {
        return this.policyForm.get('policyName')
    }
    get policyDescription() {
        return this.policyForm.get('policyDescription')
    }
    get policyType() {
        return this.policyForm.get('policyType')
    }
    get premiumAmount() {
        return this.policyForm.get('premiumAmount')
    }
    get duration() {
        return this.policyForm.get('duration')
    }

  


    onSubmit() {
        if (this.policyForm.valid) {
            console.log(this.policyForm.value)
            this.policyService.addPolicy(this.policyForm.value)
                .subscribe(
                    response => {
                        console.log('Success!', response),
                        alert("Saved Successfully!")
                        this.route.navigateByUrl('/adminpolicylist')
                    },
                    error => {
                        console.error('Error!', error)
                        alert("Policy already exist under this name!")
                        let currentUrl = this.route.url;
                        this.route.routeReuseStrategy.shouldReuseRoute = () => false;
                        this.route.onSameUrlNavigation = 'reload';
                        this.route.navigate([currentUrl]);
                    }
                );

        }
    }

    cancelBtn() {
        this.route.navigateByUrl('/adminpolicylist')
    }
    
}