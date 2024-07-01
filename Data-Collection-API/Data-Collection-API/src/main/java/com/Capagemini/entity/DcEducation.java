package com.Capagemini.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "DC_EDUCATION")
public class DcEducation {
	
	@Id
	@GeneratedValue
	private Integer educationId;
	
	private String highestDegree;
	private String universityName;
	private Integer gradutaionYear;
	private Integer caseNum;
	public Integer getEducationId() {
		return educationId;
	}
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public Integer getGradutaionYear() {
		return gradutaionYear;
	}
	public void setGradutaionYear(Integer gradutaionYear) {
		this.gradutaionYear = gradutaionYear;
	}
	public Integer getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	
	

}
