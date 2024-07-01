package com.Capagemini.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagemini.entity.DCIncomeEntity;

public interface DcIncomeRepository extends JpaRepository<DCIncomeEntity, Serializable> {

	public DCIncomeEntity findByCaseNum(Long caseNum);
}
