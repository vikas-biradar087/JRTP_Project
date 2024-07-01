package com.Capagamini.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Capagamini.entity.CaseWorker;
import com.Capagamini.repository.CaseWorkerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CaseWorkerRepository caseWorkerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CaseWorker caseWorker = caseWorkerRepository.findByUsername(username);
        if (caseWorker == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(caseWorker.getUsername())
                .password(caseWorker.getPassword())
                .roles("USER")
                .disabled(!caseWorker.isActive())
                .build();
    }
}

