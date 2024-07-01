package com.Capagamini.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagamini.entity.CitizenAppEntity;

public interface CitizenAppRepsotory extends JpaRepository<CitizenAppEntity, Serializable>{

}
