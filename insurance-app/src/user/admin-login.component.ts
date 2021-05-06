import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { User } from "src/common/user";
import { AuthenticationService } from "src/services/authenticate.service";
import { UserAuthenticateService } from "src/services/user-authenticate.service";


@Component({
    selector: 'login-admin',
    templateUrl: './admin-login.component.html'
})
export class AdminLoginComponent {
    userForm: FormGroup
    user: User
    invalidLogin = false


    constructor(private route: Router, private formBuilder: FormBuilder,
        private loginService: AuthenticationService,private userAuthService:UserAuthenticateService ) {

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
            this.user = this.userForm.value;
            if (this.loginService.authenticate(this.user.email, this.user.password)
            ) {
                this.userAuthService.removeUserName();
                this.userAuthService.setUserName('John');
                this.userAuthService.removeUserId();
                this.userAuthService.setUserId(2);
                this.route.navigate(['/adminplan'])
                this.invalidLogin = false

            } else{
                alert('Invalid details or you are not authorized!')
                this.invalidLogin = true

            }
        }
    }

}



