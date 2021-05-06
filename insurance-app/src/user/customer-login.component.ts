import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from "src/common/user";
import { UserAuthenticateService } from "src/services/user-authenticate.service";
import { UserService } from "src/services/user.service";

@Component({
    selector:'login-customer',
    templateUrl:'./customer-login.component.html'
})
export class CustomerLoginComponent{
    userForm: FormGroup
    user: User
    userDetails: User;
    userInfo : User;
    
    constructor(private route: Router, private formBuilder: FormBuilder,
        private userService: UserService,private userAuthService:UserAuthenticateService,
        private router:ActivatedRoute) {

    }
    ngOnInit() {
        this.userForm = this.formBuilder.group({
            email: ['', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
            password: ['', [Validators.required, Validators.minLength(8),
                Validators.pattern('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&,.<>"\'\\;:\{\\\}\\\[\\\]\\\|\\\+\\\-\\\=\\\_\\\)\\\(\\\)\\\`\\\/\\\\\\]])[A-Za-z0-9\d$@].{8,}')]]
        })
    
    }
    get email() {
        return this.userForm.get('email')
    }
    get password() {
        return this.userForm.get('password')
    }

    onSubmit() {

        if (this.userForm.valid) {
            console.log(this.userForm.value)
            this.user = this.userForm.value
            this.userService.userLogin(this.user.email, this.user.password)
                .subscribe((flag: boolean) => {
                    console.log(flag)
                    if (flag) {
                        this.userService.getUserId(this.user.email).subscribe((user:User)=>{
                            this.userInfo=user;
                            console.log(this.userInfo);
                            this.userAuthService.removeUserId();
                            this.userAuthService.setUserId(this.userInfo.userId);
                            this.userAuthService.removeUserName();
                            this.userAuthService.setUserName(this.userInfo.firstName);

                        })
                      
                        alert("Login Successful!")
                        this.route.navigateByUrl('/customerplan')
                       
                      }
                    else {
                        alert("Invalid username or password!")
                        this.route.navigateByUrl('/customer')
                    }

                })
        }

    }
    
}