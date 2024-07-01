package com.Capgemini.EligibilityDeterminationApi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capgemini.EligibilityDeterminationApi.entity.CitizenAppEntity;



public interface CitizenAppRepsotory extends JpaRepository<CitizenAppEntity, Serializable>{

}
