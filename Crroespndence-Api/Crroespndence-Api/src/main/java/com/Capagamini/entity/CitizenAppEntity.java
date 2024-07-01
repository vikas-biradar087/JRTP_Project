package com.Capagamini.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="CITIZEN_APPS")
public class CitizenAppEntity {
	
	@Id
	@GeneratedValue
	private Integer appId;
	
	private String fname;
	
	private String email;
	
	private Long mobileNum;
	
	private String gender;
	
	private LocalDate dob;
	
	private Long ssn;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	private Integer createdBy;
	
	private Integer updatedBy;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	private String PlanName;
	
	private String FullName;
	
	private String Planstatus;
	
	private String DenailReason;
	
	private LocalDate PlanStartdate;
	
	private LocalDate PlanEndDate;

	public LocalDate getPlanStartdate() {
		return PlanStartdate;
	}

	public void setPlanStartdate(LocalDate planStartdate) {
		PlanStartdate = planStartdate;
	}

	public LocalDate getPlanEndDate() {
		return PlanEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		PlanEndDate = planEndDate;
	}

	public String getPlanName() {
		return PlanName;
	}

	public void setPlanName(String planName) {
		PlanName = planName;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getPlanstatus() {
		return Planstatus;
	}

	public void setPlanstatus(String planstatus) {
		Planstatus = planstatus;
	}

	public String getDenailReason() {
		return DenailReason;
	}

	public void setDenailReason(String denailReason) {
		DenailReason = denailReason;
	}
	
	

}
