package com.Capagemini.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capagemini.Binding.Education;
import com.Capagemini.Binding.Income;
import com.Capagemini.Binding.Kid;
import com.Capagemini.Binding.KidsList;
import com.Capagemini.Binding.PlanSelection;
import com.Capagemini.Binding.Summary;
import com.Capagemini.entity.CitizenAppEntity;
import com.Capagemini.entity.DCCaseEntity;
import com.Capagemini.entity.DCIncomeEntity;
import com.Capagemini.entity.DCKIDSEntity;
import com.Capagemini.entity.DcEducation;
import com.Capagemini.entity.PlanEntity;
import com.Capagemini.repositories.CitizenAppRepsotory;
import com.Capagemini.repositories.DcCaseRepository;
import com.Capagemini.repositories.DcEducationRepository;
import com.Capagemini.repositories.DcIncomeRepository;
import com.Capagemini.repositories.DcKidsRepository;
import com.Capagemini.repositories.PlanentityRepository;
@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private CitizenAppRepsotory citizenAppRepsotory;
	
	@Autowired
	private DcCaseRepository dcCaseRepository;
	
	@Autowired
	private PlanentityRepository planRepo;
	
	@Autowired
	private DcIncomeRepository dcIncomeRepository;
	
	@Autowired
	private DcKidsRepository dcKidsRepository;
	
	@Autowired
	private DcEducationRepository dcEducationRepository;
	

	@Override
	public PlanSelection createCase(Integer appId) {
		
		PlanSelection planSelection=new PlanSelection();
		
		Optional<CitizenAppEntity> findById = citizenAppRepsotory.findById(appId);
		
		if(findById.isPresent()) {
			
			//create case
			
			DCCaseEntity entity=new DCCaseEntity();
			
			entity.setAppId(appId);
			
			dcCaseRepository.save(entity);
			
			planSelection.setCaseNum(entity.getCaseNum());
			
			// fetch plan name to insert into db
			List<PlanEntity> plans = planRepo.findAll();
			
			Map<Integer,String> planMap=new HashMap<>();
			
			plans.forEach(plan ->{
				planMap.put(plan.getPlanId(), plan.getPlanName());
			});
			
			// preparing response data
			planSelection.setPlansInfo(planMap);
			
			planSelection.setCaseNum(entity.getCaseNum());
		}
		
		return planSelection;
	}
	


	@Override
	public Long updateCitizenInfo(PlanSelection planSelection) {
		
		Long caseNum = planSelection.getCaseNum();
		
		Integer planId = planSelection.getPlanId();
		
		Optional<DCCaseEntity> findById = dcCaseRepository.findById(caseNum);
		
		
		if(findById.isPresent()) {
			
			DCCaseEntity caseEntity = findById.get();
			
			caseEntity.setPlanId(planId);
			
			dcCaseRepository.save(caseEntity);
		}
		
		return caseNum;
	}

	@Override
	public Long saveincomeInfo(Income income) {
		
		DCIncomeEntity entity=new DCIncomeEntity();
		
		BeanUtils.copyProperties(income, entity);
		
		dcIncomeRepository.save(entity);
		
		return income.getCaseNum();
	}

	@Override
	public Long saveEducationInfo(Education education) {
		
		DcEducation entity=new DcEducation();
		
		BeanUtils.copyProperties(education, entity);
		
		dcEducationRepository.save(entity);
		
		
		
		return education.getCaseNum();
	}

	@Override
	public Summary saveKidsInfo(KidsList kidsList) {
		
		Long caseNum = kidsList.getCaseNum();
		
		List<Kid> kids = kidsList.getKids();
		
		List<DCKIDSEntity> kidsentity=new ArrayList<>();
		
		kids.forEach(kid ->{
			DCKIDSEntity entity=new DCKIDSEntity();
			BeanUtils.copyProperties(kid,entity);
			entity.setCaseNum(caseNum);
			kidsentity.add(entity);
		});
		
		dcKidsRepository.saveAll(kidsentity);
		
		return getSummary(caseNum);
	}

	private Summary getSummary(Long caseNum) {
		
		Optional<DCCaseEntity> dcCase = dcCaseRepository.findById(caseNum);
		
		DCCaseEntity dcCaseEntity = dcCase.get();
		
		Integer planId = dcCaseEntity.getPlanId();
		Integer appId = dcCaseEntity.getAppId();
		
		Optional<PlanEntity> plan = planRepo.findById(planId);
		
		String planName = plan.get().getPlanName();
		
		Optional<CitizenAppEntity> app = citizenAppRepsotory.findById(appId);
		String fname = app.get().getFname();
		Long ssn = app.get().getSsn();
		
		
		DCIncomeEntity dcIncome = dcIncomeRepository.findByCaseNum(caseNum);
		
		DcEducation dcEducation = dcEducationRepository.findBycaseNum(caseNum);
		
		Optional<DCKIDSEntity> findById = dcKidsRepository.findById(caseNum);
		
		
		Summary summary=new Summary();
		summary.setPlanName(planName);
		summary.setFname(fname);
		summary.setSsn(ssn);
		
		// set income data
		
		//set deeducation
		
		//dcKids;
		return summary;
		
	}

}
