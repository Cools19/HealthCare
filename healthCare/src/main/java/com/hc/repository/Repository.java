package com.hc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hc.model.HealthCare;



public interface Repository extends JpaRepository < HealthCare , String > {

	Optional<HealthCare> findById(Integer id);

	void deleteById(Integer id);

	

}
