import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "src/common/user";
import { URL } from "src/url.constant";


@Injectable()
export class UserService {
    constructor(private httpClient: HttpClient) {

    }
    userLogin(email:string,pwd:string): Observable<boolean>{
        return this.httpClient.get<boolean>(`${URL.userLoginUrl}/${email}/${pwd}`)
    }
    userRegister(userData){
        return this.httpClient.post<any>(URL.userRegUrl, userData);
    }
    getUserId(email){
        return this.httpClient.get<User>(`${URL.getuserIdUrl}/${email}`);
    }


}