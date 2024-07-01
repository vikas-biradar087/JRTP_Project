package com.Capagamini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagamini.entity.CaseWorker;

public interface CaseWorkerRepository extends JpaRepository<CaseWorker, Long> {
	
    CaseWorker findByUsername(String username);
}

