import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { UserService } from "src/services/user.service";

@Component({
    selector:'user-register',
    templateUrl:'./registration.component.html'
})
export class UserRegistrationComponent{
    userForm: FormGroup;
    constructor(private route: Router, private formBuilder: FormBuilder, private userService: UserService) {

    }
    ngOnInit() {
        this.userForm = this.formBuilder.group({
            firstName: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-Z]+$')]],
            lastName: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-Z]+$')]],
            email: ['', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
            password: ['', [Validators.required, Validators.minLength(8)
            ,Validators.pattern('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&,.<>"\'\\;:\{\\\}\\\[\\\]\\\|\\\+\\\-\\\=\\\_\\\)\\\(\\\)\\\`\\\/\\\\\\]])[A-Za-z0-9\d$@].{8,}')]],
            phone: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
            city: ['', [Validators.required,Validators.minLength(3)]],


        });
    }
    get firstName() {
        return this.userForm.get('firstName')
    }
    get lastName() {
        return this.userForm.get('lastName')
    }
    get email() {
        return this.userForm.get('email')
    }
    get phone() {
        return this.userForm.get('phone')
    }
    get password() {
        return this.userForm.get('password')
    }

    get city(){
        return this.userForm.get('city')
    }


    onSubmit() {
        if (this.userForm.valid) {
            console.log(this.userForm.value)
            this.userService.userRegister(this.userForm.value)
                .subscribe(
                    response => {
                        console.log('Success!', response),
                        alert("Registration Successful!")
                        this.route.navigateByUrl('/customer')
                    },
                    error => {
                        console.error('Error!', error)
                        alert("Account already exist with given email")
                        let currentUrl = this.route.url;
                        this.route.routeReuseStrategy.shouldReuseRoute = () => false;
                        this.route.onSameUrlNavigation = 'reload';
                        this.route.navigate([currentUrl]);
                    }
                );
           
        }
    }

    cancelBtn() {
        this.route.navigateByUrl('/customer')
    }
    
}