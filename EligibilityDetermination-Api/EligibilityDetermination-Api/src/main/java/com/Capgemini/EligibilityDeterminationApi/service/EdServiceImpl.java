package com.Capgemini.EligibilityDeterminationApi.service;



import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capgemini.EligibilityDeterminationApi.binding.ElgResponse;
import com.Capgemini.EligibilityDeterminationApi.entity.CitizenAppEntity;
import com.Capgemini.EligibilityDeterminationApi.entity.CoTrgEntity;
import com.Capgemini.EligibilityDeterminationApi.entity.DCCaseEntity;
import com.Capgemini.EligibilityDeterminationApi.entity.DCIncomeEntity;
import com.Capgemini.EligibilityDeterminationApi.entity.DCKIDSEntity;
import com.Capgemini.EligibilityDeterminationApi.entity.DcEducation;
import com.Capgemini.EligibilityDeterminationApi.entity.EligibilityDeter;
import com.Capgemini.EligibilityDeterminationApi.entity.PlanEntity;
import com.Capgemini.EligibilityDeterminationApi.repository.CitizenAppRepsotory;
import com.Capgemini.EligibilityDeterminationApi.repository.CoTrgRepository;
import com.Capgemini.EligibilityDeterminationApi.repository.DcCaseRepository;
import com.Capgemini.EligibilityDeterminationApi.repository.DcEducationRepository;
import com.Capgemini.EligibilityDeterminationApi.repository.DcIncomeRepository;
import com.Capgemini.EligibilityDeterminationApi.repository.DcKidsRepository;
import com.Capgemini.EligibilityDeterminationApi.repository.EligibilityRepository;
import com.Capgemini.EligibilityDeterminationApi.repository.PlanentityRepository;

@Service
public class EdServiceImpl implements EdService {

	@Autowired
	private DcCaseRepository dcCaseRepo;
	
	@Autowired
	private PlanentityRepository planRepo;
	
	@Autowired
	private DcIncomeRepository incomeRepo;
	
	@Autowired
	private DcKidsRepository kidRepo;
	
	@Autowired
	private CitizenAppRepsotory citiRepo;
	
	@Autowired
	private DcEducationRepository eduRepo;
	
	@Autowired
	private CoTrgRepository cotrgRepo;
	
	@Autowired
	private EligibilityRepository elgRepo;
	
	boolean noKids=false; 
	
	@Override
	public ElgResponse determineEligibility(Long caseNum) {
		
		ElgResponse elgRes=new ElgResponse();
		
		Integer planId=null;
		
		String planName=null;
		
		Integer appId=null;
		
		Optional<DCCaseEntity> dcCaseEntity = dcCaseRepo.findById(caseNum);
		
		if(dcCaseEntity.isPresent()){
			planId=dcCaseEntity.get().getPlanId();
			appId=dcCaseEntity.get().getAppId();
		}
		
		else {
			return null;
		}
		
		Optional<PlanEntity> planEntity = planRepo.findById(planId);
		
		if(planEntity.isPresent()) {
		
			planName=planEntity.get().getPlanName();
			
		}
		
		Optional<CitizenAppEntity> citizenappEntity = citiRepo.findById(appId);
		CitizenAppEntity citizenApp = citizenappEntity.get();
		
		
		DCIncomeEntity income = incomeRepo.findByCaseNum(caseNum);
		
		List<DCKIDSEntity> kids = kidRepo.findBycaseNum(caseNum);
		
		
		if("SNAP".equals(planName)) {
			
			if(income.getSalaryIncome() >300) {
				
				elgRes.setPlanStatus("Denied ");
				
				elgRes.setPlanStatus("High Income");
			}
			
		}else if ("CCAP".equals(planName)) {
			
			// Wrap the boolean variable in an array
			AtomicBoolean ageStatus = new AtomicBoolean(true);

			if (!kids.isEmpty()) {
			    kids.forEach(kid -> {
			        LocalDate dob = kid.getKdiDob();
			        LocalDate today = LocalDate.now();

			        Period p = Period.between(dob, today);
			        int year = p.getYears();
			        if (year > 16) {
			            ageStatus.set(false); // Modify the value using AtomicBoolean
			        }
			    });
			}else {
				elgRes.setDenialReason("No kids Available");
				noKids=true;
			}
			
			if(income.getSalaryIncome() >300) {
				elgRes.setDenialReason("High Income");
			}
//			
			if(ageStatus.get()) {
				elgRes.setDenialReason("Kids Age");
			}
			
			if(noKids && income.getSalaryIncome()>300) {
				elgRes.setDenialReason("High income + No Kids ");
			}
			
		}else if ("Medicaid".equals(planName)) {
			
			Double salaryIncome = income.getSalaryIncome();
			
			Double rentIncome = income.getRentIncome();
			
			Double propertyIncome = income.getPropertyIncome();
			
			if(salaryIncome >300) {
				elgRes.setDenialReason("High Income");
			}
			
			if(rentIncome >0) {
				elgRes.setDenialReason("Property Income Avaliable");
			}
			
			if(propertyIncome > 0) {
				elgRes.setDenialReason("Property income Available");
			}
			
			if(rentIncome > 0 && propertyIncome >0) {
				elgRes.setDenialReason("Rental + Property income Available");
			}
			
			if(salaryIncome > 300 && rentIncome > 0 && propertyIncome >0) {
				elgRes.setDenialReason("High Income + Rental + Property income Available");
			}
			
		}else if ("Medicare".equals(planName)) {
			
			LocalDate dob = citizenApp.getDob();
			
			LocalDate now=LocalDate.now();
			
			 Period between = Period.between(dob, now);
			 
			 int years = between.getYears();
			 
			 if(years < 65) {
				 elgRes.setDenialReason("Age ");
			 }
			
			
			
			
		}else if ("QHP".equals(planName)) {
			
		}else if ("RIW".equals(planName)) {
			
			DcEducation educationEntity = eduRepo.findBycaseNum(caseNum);
			Integer gradutaionYear = educationEntity.getGradutaionYear();
			
			if(gradutaionYear <=0) {
				elgRes.setDenialReason("No graducation");
			}
			
			if(income.getSalaryIncome() >0) {
				elgRes.setDenialReason("Already an Employee");
			}
			
		}
		
		elgRes.setPlanName(planName);
		
		if(elgRes.getDenialReason() !=null) {
			elgRes.setDenialReason("Denied");
			
		}else {
			elgRes.setPlanStatus("Approved !!");
			elgRes.setPlanStartDate(LocalDate.now().plusDays(1));
			elgRes.setPlanEndDate(LocalDate.now().plusMonths(3));
			elgRes.setBenefitAmt(350.00);
			
		}
		
		
		EligibilityDeter egEntity=new EligibilityDeter();
		
		BeanUtils.copyProperties(elgRes, egEntity);
		elgRepo.save(egEntity);
		
		CoTrgEntity coEntity=new CoTrgEntity();
		coEntity.setCaseNum(caseNum);
		coEntity.setTrgStatus("Pending");
		
		cotrgRepo.save(coEntity);
		
		return elgRes;
	}

}
