package com.Capagamini.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CO_TRIGGERS")
public class CoTrgEntity {
	
	@Id
	@GeneratedValue
	private Integer coTrgId;
	
	private Long caseNum;
	
	private Long appId;
	
	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	private byte[] pdf;
	
	private String trgStatus;

	public Integer getCoTrgId() {
		return coTrgId;
	}

	public void setCoTrgId(Integer coTrgId) {
		this.coTrgId = coTrgId;
	}

	public Long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	public String getTrgStatus() {
		return trgStatus;
	}

	public void setTrgStatus(String trgStatus) {
		this.trgStatus = trgStatus;
	}
	
	

}
