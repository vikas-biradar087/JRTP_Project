package com.Capagemini.Binding;

public class Summary {
	
	private String fname;
	
	private Long ssn;
	
	private String planName;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	private PlanSelection planInfo;
	
	private Income incomeInfo;
	
	private Education educationInfo;
	
	private KidsList kidsInfo;

	public PlanSelection getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanSelection planInfo) {
		this.planInfo = planInfo;
	}

	public Income getIncomeInfo() {
		return incomeInfo;
	}

	public void setIncomeInfo(Income incomeInfo) {
		this.incomeInfo = incomeInfo;
	}

	public Education getEducationInfo() {
		return educationInfo;
	}

	public void setEducationInfo(Education educationInfo) {
		this.educationInfo = educationInfo;
	}

	public KidsList getKidsInfo() {
		return kidsInfo;
	}

	public void setKidsInfo(KidsList kidsInfo) {
		this.kidsInfo = kidsInfo;
	}
	
	

}
