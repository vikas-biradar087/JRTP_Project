package com.Capagemini.Binding;

import java.util.Map;

public class PlanSelection {
	
	private Long caseNum;
	
	private Integer planId;
	
	private Map<Integer,String> plansInfo;
	
	

	public Map<Integer, String> getPlansInfo() {
		return plansInfo;
	}

	public void setPlansInfo(Map<Integer, String> plansInfo) {
		this.plansInfo = plansInfo;
	}

	public Long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
	

}
