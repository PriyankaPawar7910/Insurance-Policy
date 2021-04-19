package com.insurancepolicy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancepolicy.model.Policy;
import com.insurancepolicy.repository.PolicyRepository;
@Service
public class PolicyService implements IPolicyService{
	
	@Autowired
	PolicyRepository policyRepository;

	@Override
	public List<Policy> getAllPolicies() {
		return policyRepository.findAll();
	}

	@Override
	public Policy addPolicy(Policy policy) {
		return policyRepository.save(policy);
	}

	@Override
	public Policy getPolicy(int policyId) {
		return policyRepository.findById(policyId).orElse(null);
	}

	@Override
	public Policy updatePolicy(Policy policy) {
		Policy policyDetails = policyRepository.findById(policy.getPolicyId()).orElse(null);
		if(policyDetails!=null) {
			policyRepository.save(policy);
		}
		return policy;
	}

	@Override
	public List<Policy> deletePolicy(int policyId) {
		Policy policyDetails = policyRepository.findById(policyId).orElse(null);
		if(policyDetails!=null) {
			policyRepository.delete(policyDetails);
		}
		return policyRepository.findAll();
	}

}
