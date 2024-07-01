package com.Capagamini.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagamini.entity.DCCaseEntity;



public interface DcCaseRepository extends JpaRepository<DCCaseEntity, Serializable> {

}
