package com.Amdocs.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Amdocs.Entity.State;

public interface StateRepo extends JpaRepository<State, Serializable>{

	
	List<State> findByCountryId(long countryId);
	
	
	
}
