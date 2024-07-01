package com.Capagamini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.Capagamini.entity.CaseWorker;
import com.Capagamini.service.CaseWorkerService;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CaseWorkerService caseWorkerService;

    @GetMapping("/caseWorkers")
    @PreAuthorize("hasRole('ADMIN')") // Restrict access to ADMIN role
    public ResponseEntity<List<CaseWorker>> getAllCaseWorkers() {
        List<CaseWorker> caseWorkers = caseWorkerService.getAllCaseWorkers();
        return new ResponseEntity<>(caseWorkers, HttpStatus.OK);
    }

    @PostMapping("/caseWorkers")
    @PreAuthorize("hasRole('ADMIN')") // Restrict access to ADMIN role
    public ResponseEntity<CaseWorker> createCaseWorker(@RequestBody CaseWorker caseWorker) {
        CaseWorker createdCaseWorker = caseWorkerService.createCaseWorker(caseWorker);
        return new ResponseEntity<>(createdCaseWorker, HttpStatus.CREATED);
    }

    @PutMapping("/caseWorkers/activate/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Restrict access to ADMIN role
    public ResponseEntity<Void> activateCaseWorker(@PathVariable Long id) {
        caseWorkerService.activateCaseWorker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/caseWorkers/deactivate/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Restrict access to ADMIN role
    public ResponseEntity<Void> deactivateCaseWorker(@PathVariable Long id) {
        caseWorkerService.deactivateCaseWorker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/caseWorkers/{id}")
   @PreAuthorize("hasRole('ADMIN')") // Restrict access to ADMIN role
    public ResponseEntity<Void> deleteCaseWorker(@PathVariable Long id) {
        caseWorkerService.deleteCaseWorker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
