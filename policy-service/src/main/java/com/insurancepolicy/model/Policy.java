package com.insurancepolicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "policies")
public class Policy {
	@Id
	@SequenceGenerator(name="policy_seq",sequenceName="policy_seq",allocationSize = 1)       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="policy_seq")
	@Column(name = "policy_id")
	private int policyId;
	@Column(name = "policy_name")
	private String policyName;
	@Column(name = "policy_desc")
	private String policyDescription;
	@Column
	private int duration;
	@Column(name = "premium_amt")
	private float premiumAmount;
	@Column(name = "policy_type")
	private String policyType;
	
	public Policy() {
		// TODO Auto-generated constructor stub
	}



	public Policy(int policyId, String policyName, String policyDescription, int duration, float premiumAmount,
			String policyType) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyDescription = policyDescription;
		this.duration = duration;
		this.premiumAmount = premiumAmount;
		this.policyType = policyType;
	}



	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}


	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	
	public String getPolicyDescription() {
		return policyDescription;
	}



	public void setPolicyDescription(String policyDescription) {
		this.policyDescription = policyDescription;
	}



	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyDescription="
				+ policyDescription + ", duration=" + duration + ", premiumAmount=" + premiumAmount + ", policyType="
				+ policyType + "]";
	}





	

	
}
