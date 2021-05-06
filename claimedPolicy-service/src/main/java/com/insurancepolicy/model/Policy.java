package com.insurancepolicy.model;

public class Policy {

	private int policyId;
	private String policyName;
	private String policyDescription;
	private int duration;
	private float premiumAmount;
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
