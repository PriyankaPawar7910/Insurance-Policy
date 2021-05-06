import { Component, OnInit } from "@angular/core";
import { User } from "src/common/user";
import { UserAuthenticateService } from "src/services/user-authenticate.service";
import { UserService } from "src/services/user.service";

@Component({
    selector:'user-profile',
    templateUrl:'./profile.component.html'
})
export class ProfileComponent implements OnInit{
    user : User
    constructor(private userService:UserService, private userAuthService :UserAuthenticateService){

    }
    ngOnInit(){
        this.userService.getUser(+this.userAuthService.getUserId()).subscribe((userInfo: User) => {
            this.user = userInfo;
          })
    }

}