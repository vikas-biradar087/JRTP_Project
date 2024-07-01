package com.Capagamini.service;

import java.util.List;

import com.Capagamini.entity.CaseWorker;

public interface CaseWorkerService {

	public List<CaseWorker> getAllCaseWorkers();

//	public CaseWorker getCaseWorkerById(Long id);

	public CaseWorker createCaseWorker(CaseWorker caseWorker);

	public void activateCaseWorker(Long id);

	void deactivateCaseWorker(Long id);

	void deleteCaseWorker(Long id);

	public CaseWorker findByUsername(String username);

}
