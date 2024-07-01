package com.Capgemini.EligibilityDeterminationApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Capgemini.EligibilityDeterminationApi.binding.ElgResponse;
import com.Capgemini.EligibilityDeterminationApi.service.EdService;

@RestController
public class EdRestController {
	
	@Autowired
	private EdService edService;
	
	@GetMapping("/eligibility/{caseNum}")
	public ResponseEntity<ElgResponse> Edetermine(@PathVariable Long casenum){
		ElgResponse response = edService.determineEligibility(casenum);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
