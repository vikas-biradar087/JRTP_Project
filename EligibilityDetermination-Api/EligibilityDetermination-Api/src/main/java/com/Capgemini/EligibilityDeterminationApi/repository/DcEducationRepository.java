package com.Capgemini.EligibilityDeterminationApi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capgemini.EligibilityDeterminationApi.entity.DcEducation;



public interface DcEducationRepository extends JpaRepository<DcEducation, Serializable> {

	public DcEducation findBycaseNum(Long caseNum);
}
