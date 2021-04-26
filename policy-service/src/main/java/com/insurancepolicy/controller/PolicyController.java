package com.insurancepolicy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurancepolicy.model.Policy;
import com.insurancepolicy.service.IPolicyService;

@RestController
@RequestMapping("/policy")
@CrossOrigin
public class PolicyController {
	
	@Autowired
	IPolicyService policyService;
	
	Logger logger = LoggerFactory.getLogger(PolicyController.class);
	
	@GetMapping("/allPolicies")
	public List<Policy> getAllPolicies() {
		logger.info("All  policies returned from Policy Controller");
		return policyService.getAllPolicies();
	}
	
	@PostMapping("/add")
	public Policy addPolicy(@RequestBody Policy policy) {
		logger.info("Added policy from Policy Controller");
		return policyService.addPolicy(policy);
	}
	
	@GetMapping("/getPolicy/{id}")
	public Policy getPolicy(@PathVariable("id") int policyId) {
		logger.info("Returned  policy from Policy Controller");
		return policyService.getPolicy(policyId);
	}
	
	@PutMapping("/update")
	public Policy updatePolicy(@RequestBody Policy policy) {
		logger.info("Updated policy from Policy Controller");
		return policyService.updatePolicy(policy);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Policy> deletePolicy(@PathVariable("id") int policyId){
		logger.info("Deleted policy from Policy Controller");
		return policyService.deletePolicy(policyId);
	}

}
