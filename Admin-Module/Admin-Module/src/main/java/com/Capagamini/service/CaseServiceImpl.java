package com.Capagamini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Capagamini.entity.CaseWorker;
import com.Capagamini.repository.CaseWorkerRepository;

public class CaseServiceImpl implements CaseWorkerService{
	
	@Autowired
    private CaseWorkerRepository caseWorkerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<CaseWorker> getAllCaseWorkers() {
        return caseWorkerRepository.findAll();
    }


    public CaseWorker createCaseWorker(CaseWorker caseWorker) {
        // Encrypt password before saving
        caseWorker.setPassword(passwordEncoder.encode(caseWorker.getPassword()));
        return caseWorkerRepository.save(caseWorker);
    }

    public void activateCaseWorker(Long id) {
        Optional<CaseWorker> optionalCaseWorker = caseWorkerRepository.findById(id);
        optionalCaseWorker.ifPresent(caseWorker -> {
            caseWorker.setActive(true);
            caseWorkerRepository.save(caseWorker);
        });
    }

    public void deactivateCaseWorker(Long id) {
        Optional<CaseWorker> optionalCaseWorker = caseWorkerRepository.findById(id);
        optionalCaseWorker.ifPresent(caseWorker -> {
            caseWorker.setActive(false);
            caseWorkerRepository.save(caseWorker);
        });
    }

    public void deleteCaseWorker(Long id) {
        caseWorkerRepository.deleteById(id);
    }

    public CaseWorker findByUsername(String username) {
        return caseWorkerRepository.findByUsername(username);
    }


	

}
