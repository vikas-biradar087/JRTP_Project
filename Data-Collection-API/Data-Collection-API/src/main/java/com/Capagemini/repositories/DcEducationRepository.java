package com.Capagemini.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagemini.entity.DcEducation;

public interface DcEducationRepository extends JpaRepository<DcEducation, Serializable> {

	public DcEducation findBycaseNum(Long caseNum);
}
