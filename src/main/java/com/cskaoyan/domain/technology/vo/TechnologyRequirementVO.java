package com.cskaoyan.domain.technology.vo;


import com.cskaoyan.domain.technology.TechnologyRequirement;

public class TechnologyRequirementVO extends TechnologyRequirement{
	
	private String technologyName;

	private String technologyPlanId;

	private int  batchAmount;

	public int getBatchAmount() {
		return batchAmount;
	}

	public void setBatchAmount(int batchAmount) {
		this.batchAmount = batchAmount;
	}

	public String getTechnologyPlanId() {
		return technologyPlanId;
	}

	public void setTechnologyPlanId(String technologyPlanId) {
		this.technologyPlanId = technologyPlanId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	
}