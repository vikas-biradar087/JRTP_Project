package com.Capagemini.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagemini.entity.DCCaseEntity;

public interface DcCaseRepository extends JpaRepository<DCCaseEntity, Serializable> {

}
