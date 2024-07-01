package com.Capgemini.EligibilityDeterminationApi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capgemini.EligibilityDeterminationApi.entity.EligibilityDeter;

public interface EligibilityRepository extends JpaRepository<EligibilityDeter, Serializable> {

}
