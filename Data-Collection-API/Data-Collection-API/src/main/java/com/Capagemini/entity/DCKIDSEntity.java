package com.Capagemini.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="DC_KIDS")
public class DCKIDSEntity {
	
	@Id
	@GeneratedValue
	private Integer kidId;
	
	private String kidName;
	
	private String kidGender;
	
	private LocalDate kdiDob;
	
	private Long kidSsn;
	
	private Long caseNum;

	public Integer getKidId() {
		return kidId;
	}

	public void setKidId(Integer kidId) {
		this.kidId = kidId;
	}

	public String getKidName() {
		return kidName;
	}

	public void setKidName(String kidName) {
		this.kidName = kidName;
	}

	public String getKidGender() {
		return kidGender;
	}

	public void setKidGender(String kidGender) {
		this.kidGender = kidGender;
	}

	public LocalDate getKdiDob() {
		return kdiDob;
	}

	public void setKdiDob(LocalDate kdiDob) {
		this.kdiDob = kdiDob;
	}

	public Long getKidSsn() {
		return kidSsn;
	}

	public void setKidSsn(Long kidSsn) {
		this.kidSsn = kidSsn;
	}

	public Long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Long caseNum2) {
		this.caseNum = caseNum2;
	}
	
	
	
	

}
