package com.Capagemini.service;

import com.Capagemini.Binding.Education;
import com.Capagemini.Binding.Income;
import com.Capagemini.Binding.KidsList;
import com.Capagemini.Binding.PlanSelection;
import com.Capagemini.Binding.Summary;

public interface DcService {
	
	public PlanSelection createCase(Integer appId);
	
	public Long updateCitizenInfo(PlanSelection planSelection);
	
	public Long saveincomeInfo(Income income);
	
	public Long saveEducationInfo(Education education);
	
	public Summary saveKidsInfo(KidsList kidsList);
	

}
