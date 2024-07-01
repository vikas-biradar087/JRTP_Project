package com.Amdocs.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Amdocs.Entity.Country;

public interface CountryRepo extends JpaRepository<Country, Serializable>{

	
}
