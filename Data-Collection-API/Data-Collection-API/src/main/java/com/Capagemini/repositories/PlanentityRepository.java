package com.Capagemini.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagemini.entity.PlanEntity;

public interface PlanentityRepository extends JpaRepository<PlanEntity, Serializable> {

}
