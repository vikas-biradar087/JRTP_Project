package com.Capagemini.Binding;

import java.time.LocalDate;

public class Kid {
	
	private Integer kidId;
	
	private String kidName;
	
	private String kidGender;
	
	private LocalDate kdiDob;
	
	private Long kidSsn;

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
	
	
	

}
