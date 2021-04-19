package com.insurancepolicy.controller;

import java.util.List;

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
	
	@GetMapping("/allPolicies")
	public List<Policy> getAllPolicies() {
		return policyService.getAllPolicies();
	}
	
	@PostMapping("/add")
	public Policy addPolicy(@RequestBody Policy policy) {
		return policyService.addPolicy(policy);
	}
	
	@GetMapping("/getPolicy/{id}")
	public Policy getPolicy(@PathVariable("id") int policyId) {
		return policyService.getPolicy(policyId);
	}
	
	@PutMapping("/update")
	public Policy updatePolicy(@RequestBody Policy policy) {
		return policyService.updatePolicy(policy);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Policy> deletePolicy(@PathVariable("id") int policyId){
		return policyService.deletePolicy(policyId);
	}

}
