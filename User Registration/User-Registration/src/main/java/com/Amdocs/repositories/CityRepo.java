package com.Amdocs.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Amdocs.Entity.City;
import com.Amdocs.Entity.State;

public interface CityRepo extends JpaRepository<City, Serializable>{

	List<City> findByStateId(long stateId);
}
