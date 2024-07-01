package com.Capgemini.EligibilityDeterminationApi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Capgemini.EligibilityDeterminationApi.entity.DCKIDSEntity;

public interface DcKidsRepository extends JpaRepository<DCKIDSEntity, Serializable> {
	
	List<DCKIDSEntity> findBycaseNum(Long caseNum);

}
