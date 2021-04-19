package com.insurancepolicy.service;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.insurancepolicy.model.ClaimedPolicy;
import com.insurancepolicy.model.Policy;
import com.insurancepolicy.model.ResponseTemplate;
import com.insurancepolicy.model.User;
import com.insurancepolicy.repository.ClaimedPolicyRepository;

@Service
public class ClaimedPolicyService implements IClaimedPolicyService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ClaimedPolicyRepository claimPolicyRepository;
	
	Logger logger = LoggerFactory.getLogger(ClaimedPolicyService.class);


	@Override
	public List<ClaimedPolicy> getAllClaimPolicies() {
		return claimPolicyRepository.findAll();
	}

	@Override
	public ClaimedPolicy addClaimPolicy(ClaimedPolicy claimPolicy) {
		return claimPolicyRepository.save(claimPolicy);
	}

	@Override
	public ClaimedPolicy getClaimPolicy(int id) {
		return claimPolicyRepository.findById(id).orElse(null);
	}

	@Override
	public ClaimedPolicy updateClaimPolicy(ClaimedPolicy claimPolicy) {
		ClaimedPolicy policyDetails = claimPolicyRepository.findById(claimPolicy.getPlanId()).orElse(null);
		if(policyDetails!=null) {
			claimPolicyRepository.save(claimPolicy);
		}
		return null;
	}

	@Override
	public List<ClaimedPolicy> deleteClaimPolicy(int planId) {
		ClaimedPolicy policyDetails = claimPolicyRepository.findById(planId).orElse(null);
		if(policyDetails!=null) {
			claimPolicyRepository.delete(policyDetails);
		}
		return claimPolicyRepository.findAll();
	}

	@Override
	public List<ResponseTemplate> getClaimPolicyByUser(int userId) {	
		
    List<ResponseTemplate> responseTemplates = new ArrayList<ResponseTemplate>();
	ResponseTemplate responseTemplate = null;
	
	List<ClaimedPolicy> policyList = claimPolicyRepository.findAllByUserId(userId);
	ClaimedPolicy claimPolicyDetails =null;
	
	for(int i=0;i<policyList.size();i++) {
		claimPolicyDetails = policyList.get(i);
		logger.info("CalimPolicy="+claimPolicyDetails);
		User user = restTemplate.getForObject("http://localhost:8001/user/getUser/"+userId, User.class);
		logger.info("User="+user);
		logger.info("Policy Id="+claimPolicyDetails.getPolicyId());
		Policy policy = restTemplate.getForObject("http://localhost:8001/policy/getPolicy/"+claimPolicyDetails.getPolicyId(), Policy.class);
		logger.info("Policy="+policy);

		
		responseTemplate = new ResponseTemplate(user, policy, claimPolicyDetails);
		
		responseTemplates.add(i,responseTemplate);			
	}	

	return responseTemplates;
	}
	
	
	

}
