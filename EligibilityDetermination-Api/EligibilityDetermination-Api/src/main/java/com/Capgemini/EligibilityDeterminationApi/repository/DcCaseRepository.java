package com.Capgemini.EligibilityDeterminationApi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capgemini.EligibilityDeterminationApi.entity.DCCaseEntity;


public interface DcCaseRepository extends JpaRepository<DCCaseEntity, Serializable> {

}
