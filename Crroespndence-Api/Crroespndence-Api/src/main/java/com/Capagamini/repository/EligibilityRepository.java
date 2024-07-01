package com.Capagamini.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagamini.entity.EligibilityDeter;



public interface EligibilityRepository extends JpaRepository<EligibilityDeter, Serializable> {

	public EligibilityDeter findByCaseNum(Long caseNum);
}
