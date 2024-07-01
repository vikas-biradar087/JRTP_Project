package com.Capagemini.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capagemini.entity.CitizenAppEntity;

public interface CitizenAppRepsotory extends JpaRepository<CitizenAppEntity, Serializable>{

}
