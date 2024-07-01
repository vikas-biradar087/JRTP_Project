package com.Capagemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Capagemini.Binding.Education;
import com.Capagemini.Binding.Income;
import com.Capagemini.Binding.KidsList;
import com.Capagemini.Binding.PlanSelection;
import com.Capagemini.Binding.Summary;
import com.Capagemini.service.DcService;

@RestController
public class DcController {

	@Autowired
	private DcService dcService;
	
	@GetMapping("/case/{appId}")
	public ResponseEntity<PlanSelection> createCase(@PathVariable Integer appId){
		PlanSelection planSelCase = dcService.createCase(appId);
		return new ResponseEntity<>(planSelCase,HttpStatus.OK);
	}
	
	@PostMapping("/applayPlan")
	public ResponseEntity<Long> applyPlan(@RequestBody PlanSelection plan){
		Long caseNum = dcService.updateCitizenInfo(plan);
		return new ResponseEntity<>(caseNum,HttpStatus.OK);
	}
	
	@PostMapping("/saveincome")
	public ResponseEntity<Long> saveIncome(@RequestBody Income income){
		Long caseNum = dcService.saveincomeInfo(income);
		return new ResponseEntity<Long>(caseNum,HttpStatus.OK);
	}
	
	@PostMapping("/saveEducation")
	public ResponseEntity<Long> saveEducation(@RequestBody Education education){
		Long caseNum = dcService.saveEducationInfo(education);
		return new ResponseEntity<Long>(caseNum,HttpStatus.OK);
	}
	
	@PostMapping("/saveKids")
	public ResponseEntity<Summary> saveKids(@RequestBody KidsList kidsList){
		Summary saveKidsInfo = dcService.saveKidsInfo(kidsList);
		return new ResponseEntity<>(saveKidsInfo,HttpStatus.OK);
	}
	
	
	
}
