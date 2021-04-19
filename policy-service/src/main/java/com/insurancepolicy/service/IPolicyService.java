package com.insurancepolicy.service;

import java.util.List;

import com.insurancepolicy.model.Policy;

public interface IPolicyService {

	List<Policy> getAllPolicies();

	Policy addPolicy(Policy policy);

	Policy getPolicy(int policyId);

	Policy updatePolicy(Policy policy);

	List<Policy> deletePolicy(int policyId);

}
