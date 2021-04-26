package com.insurancepolicy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurancepolicy.exception.NotFoundException;
import com.insurancepolicy.model.ClaimedPolicy;
import com.insurancepolicy.model.Policy;
import com.insurancepolicy.repository.ClaimedPolicyRepository;
import com.insurancepolicy.repository.PolicyRepository;
@Service
public class PolicyService implements IPolicyService{
	
	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	ClaimedPolicyRepository claimPolicyRepository;
	
	Logger logger = LoggerFactory.getLogger(PolicyService.class);


	@Override
	public List<Policy> getAllPolicies() {
		logger.info("All  policies returned from Policy Service");
		return policyRepository.findAll();
	}

	@Override
	public Policy addPolicy(Policy policy) {
		if((policyRepository.findByPolicyName(policy.getPolicyName())!=null)) {
			throw new NotFoundException("Policy already existed!");
		}
		logger.info("Added policy from Policy Service");
		return policyRepository.save(policy);
	}

	@Override
	public Policy getPolicy(int policyId) {
		logger.info("Returned  policy from Policy Service");
		return policyRepository.findById(policyId).orElse(null);
	}

	@Override
	public Policy updatePolicy(Policy policy) {
		Policy policyDetails = policyRepository.findById(policy.getPolicyId()).orElse(null);
		if(policyDetails!=null) {
			policyRepository.save(policy);
		}
		logger.info("Updated policy from Policy Service");
		return policy;
	}

	@Override
	public List<Policy> deletePolicy(int policyId) {
		Policy policyDetails = policyRepository.findById(policyId).orElse(null);
		if(policyDetails!=null) {
			policyRepository.delete(policyDetails);
			List<ClaimedPolicy> policyList = claimPolicyRepository.findAllByPolicyId(policyId);
			for(int i=0;i<policyList.size();i++) {
				ClaimedPolicy claimPolicy = policyList.get(i);
				claimPolicyRepository.delete(claimPolicy);
			}
		}
		logger.info("Deleted policy from Policy Service");
		return policyRepository.findAll();
	}

}
