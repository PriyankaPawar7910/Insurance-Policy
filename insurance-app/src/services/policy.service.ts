import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Policy } from "src/common/policy";
import { UserPolicy } from "src/common/user-policy";
import { URL } from "src/url.constant";


@Injectable()
export class PolicyService {
    constructor(private httpClient: HttpClient) {

    }

    getAllPolicies(): Observable<Policy[]> {
        return this.httpClient.get<Policy[]>(URL.getAllPoliciesUrl);
    }

    getPolicy(id:number):Observable<Policy>{
        return this.httpClient.get<Policy>(`${URL.getPolicyUrl}/${id}`);
    }

    addPolicy(policyData){
        return this.httpClient.post<any>(URL.addPolicyUrl, policyData);
    }
    removePolicy(id):Observable<Policy[]>{
        return this.httpClient.delete<Policy[]>(`${URL.removePolicyUrl}/${id}`);
    }
    updatePolicy(policyData){
        return this.httpClient.put<any>(URL.updatePolicyUrl, policyData);
    }

}