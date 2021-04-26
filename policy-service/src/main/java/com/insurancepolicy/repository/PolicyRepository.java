package com.insurancepolicy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurancepolicy.model.Policy;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	public Policy findByPolicyName(String policyName);
	
}
