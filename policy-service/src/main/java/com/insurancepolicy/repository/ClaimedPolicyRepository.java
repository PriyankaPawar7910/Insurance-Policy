package com.insurancepolicy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurancepolicy.model.ClaimedPolicy;

@Repository
public interface ClaimedPolicyRepository extends JpaRepository<ClaimedPolicy, Integer>{
	public List<ClaimedPolicy> findAllByUserId(int userId);
}
