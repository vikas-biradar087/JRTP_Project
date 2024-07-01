package com.Capagamini.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagamini.entity.CoTrgEntity;



public interface CoTrgRepository extends JpaRepository<CoTrgEntity, Serializable> {

	public List<CoTrgEntity> findByTrgStatus(String status);
	
	public CoTrgEntity findByCaseNum(Long caseNum);
	
}
