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

import com.insurancepolicy.model.ClaimedPolicy;
import com.insurancepolicy.model.ResponseTemplate;
import com.insurancepolicy.service.IClaimedPolicyService;

@RestController
@RequestMapping("/claimpolicy")
@CrossOrigin
public class ClaimedPolicyController {
	
	@Autowired
	IClaimedPolicyService claimedPolicyService;
	
	@GetMapping("/getAll")
	public List<ClaimedPolicy> getAllClaimPolicies(){
		return claimedPolicyService.getAllClaimPolicies();
	}
	
	@PostMapping("/add")
	public ClaimedPolicy addClaimPolicy(@RequestBody ClaimedPolicy claimPolicy) {
		return claimedPolicyService.addClaimPolicy(claimPolicy);
	}
	
	@GetMapping("/getClaimPolicy/{id}")
	public ClaimedPolicy getClaimPolicy(@PathVariable("id") int id) {
		return claimedPolicyService.getClaimPolicy(id);
	}
	
	@GetMapping("/getUserClaimPolicy/{id}")
	public List<ResponseTemplate> getClaimPolicyByUser(@PathVariable("id") int userId) {
		return claimedPolicyService.getClaimPolicyByUser(userId);
	}
	
	@PutMapping("/update")
	public ClaimedPolicy updateClaimPolicy(@RequestBody ClaimedPolicy claimPolicy) {
		return claimedPolicyService.updateClaimPolicy(claimPolicy);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<ClaimedPolicy> deleteClaimPolicy(@PathVariable("id") int planId){
		return claimedPolicyService.deleteClaimPolicy(planId);
	}

}
