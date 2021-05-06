package com.insurancepolicy.service;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.insurancepolicy.exception.NotFoundException;
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
	public List<ResponseTemplate> getAllClaimPolicies() {
		List<ResponseTemplate> responseTemplates = new ArrayList<ResponseTemplate>();
		ResponseTemplate responseTemplate = null;

		List<ClaimedPolicy> policyList = claimPolicyRepository.findAll();
		ClaimedPolicy claimPolicyDetails = null;

		for (int i = 0; i < policyList.size(); i++) {
			claimPolicyDetails = policyList.get(i);
			logger.info("CalimPolicy=" + claimPolicyDetails);
			User user = restTemplate
					.getForObject("http://localhost:8002/user/getUser/" + claimPolicyDetails.getUserId(), User.class);
			logger.info("User=" + user);
			logger.info("Policy Id=" + claimPolicyDetails.getPolicyId());
			Policy policy = restTemplate.getForObject(
					"http://localhost:8001/policy/getPolicy/" + claimPolicyDetails.getPolicyId(), Policy.class);
			logger.info("Policy=" + policy);

			responseTemplate = new ResponseTemplate(user, policy, claimPolicyDetails);

			responseTemplates.add(i, responseTemplate);
		}
		logger.info("All claim polies returned from ClaimPolicy Service");
		return responseTemplates;

	}

	@Override
	public ClaimedPolicy addClaimPolicy(ClaimedPolicy claimPolicy) throws NotFoundException {
		ClaimedPolicy claimedPolicies = claimPolicyRepository.findByPolicyIdAndUserId(claimPolicy.getPolicyId(),
				claimPolicy.getUserId());
		if (claimedPolicies!=null) {
			throw new NotFoundException("Only taken ");

		}
		else
			logger.info("Added claim policy from ClaimPolicy Service");
			return claimPolicyRepository.save(claimPolicy);
	}

	@Override
	public ClaimedPolicy getClaimPolicy(int id) {
		logger.info("Returned claim policy from ClaimPolicy Service");
		return claimPolicyRepository.findById(id).orElse(null);
	}

	@Override
	public ClaimedPolicy updateClaimPolicy(ClaimedPolicy claimPolicy) {
		ClaimedPolicy policyDetails = claimPolicyRepository.findById(claimPolicy.getPlanId()).orElse(null);
		if (policyDetails != null) {
			logger.info("Updated claim policy from ClaimPolicy Service");
			claimPolicyRepository.save(claimPolicy);
		}
		return claimPolicy;
	}

	@Override
	public List<ClaimedPolicy> deleteClaimPolicy(int planId) {
		ClaimedPolicy policyDetails = claimPolicyRepository.findById(planId).orElse(null);
		if (policyDetails != null) {
			claimPolicyRepository.delete(policyDetails);
		}
		logger.info("Deleted claim policy from ClaimPolicy Service");
		return claimPolicyRepository.findAll();
	}

	@Override
	public List<ResponseTemplate> getClaimPolicyByUser(int userId) {

		List<ResponseTemplate> responseTemplates = new ArrayList<ResponseTemplate>();
		ResponseTemplate responseTemplate = null;

		List<ClaimedPolicy> policyList = claimPolicyRepository.findAllByUserId(userId);
		if(policyList.isEmpty()) {
			throw new NotFoundException("You don't have policies");
		}
		ClaimedPolicy claimPolicyDetails = null;

		for (int i = 0; i < policyList.size(); i++) {
			claimPolicyDetails = policyList.get(i);
			logger.info("CalimPolicy=" + claimPolicyDetails);
			User user = restTemplate.getForObject("http://localhost:8002/user/getUser/" + userId, User.class);
			logger.info("User=" + user);
			logger.info("Policy Id=" + claimPolicyDetails.getPolicyId());
			Policy policy = restTemplate.getForObject(
					"http://localhost:8001/policy/getPolicy/" + claimPolicyDetails.getPolicyId(), Policy.class);
			logger.info("Policy=" + policy);

			responseTemplate = new ResponseTemplate(user, policy, claimPolicyDetails);

			responseTemplates.add(i, responseTemplate);
		}
		logger.info("Returned claim policy by user from ClaimPolicy Service");
		return responseTemplates;
	}

}
