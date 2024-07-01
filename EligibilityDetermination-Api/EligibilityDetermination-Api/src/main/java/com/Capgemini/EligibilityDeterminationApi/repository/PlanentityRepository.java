package com.Capgemini.EligibilityDeterminationApi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capgemini.EligibilityDeterminationApi.entity.PlanEntity;



public interface PlanentityRepository extends JpaRepository<PlanEntity, Serializable> {

}
