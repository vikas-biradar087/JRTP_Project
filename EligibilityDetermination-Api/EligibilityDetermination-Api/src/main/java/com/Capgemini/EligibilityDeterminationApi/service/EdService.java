package com.Capgemini.EligibilityDeterminationApi.service;

import com.Capgemini.EligibilityDeterminationApi.binding.ElgResponse;

public interface EdService {
	
	public ElgResponse determineEligibility(Long caseNum);

}
