import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Policy } from "src/common/policy";
import { UserPolicy } from "src/common/user-policy";
import { URL } from "src/url.constant";


@Injectable()
export class UserPolicyService {
    constructor(private httpClient: HttpClient) {

    }
    getUserPolicies():Observable<UserPolicy[]>{
        return this.httpClient.get<UserPolicy[]>(URL.getUserPolicy);
    }
    claimPolicy(policyData){
        return this.httpClient.post<any>(URL.addClaimPolicyUrl, policyData);

    }
    getUserPoliciesById(id):Observable<UserPolicy[]>{
        return this.httpClient.get<UserPolicy[]>(`${URL.viewUserPolicyUrl}/${id}`);
    
    }
    removeUserPolicy(id):Observable<UserPolicy[]>{
        return this.httpClient.delete<UserPolicy[]>(`${URL.removeUserPolicyUrl}/${id}`);
    }
    
}