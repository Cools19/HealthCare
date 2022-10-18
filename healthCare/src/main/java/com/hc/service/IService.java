package com.hc.service;

import java.util.List;
import java.util.Optional;

import com.hc.model.HealthCare;

public interface IService {
	
	Integer saveHealthCare(HealthCare healthCare);
	public List<HealthCare>getAllHealthCare();
	Optional<HealthCare>getHealthCare(Integer id);
	public String deleteHealthCare(Integer id);
	public HealthCare updateHealthCare (HealthCare healthCare , Integer  id);
	public void deleteAll();
	
	
	
	

}
