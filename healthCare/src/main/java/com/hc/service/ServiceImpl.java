package com.hc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.model.HealthCare;
import com.hc.repository.Repository;
@Service
public class ServiceImpl implements IService {
	
	@Autowired
	Repository repository;

	@Override
	public Integer saveHealthCare(HealthCare healthCare) {
		HealthCare savedHealthCare=repository .save(healthCare);
		
		return savedHealthCare.getId();
	}

	@Override
	public List<HealthCare> getAllHealthCare() {
		
		return repository.findAll();
	}

	@Override
	public Optional<HealthCare> getHealthCare(Integer id) {
		return repository.findById(id);
	}

	@Override
	public String deleteHealthCare(Integer id) {
			repository.deleteById(id);
			return "Deleted";
		 
	}

	@Override
	public HealthCare updateHealthCare(HealthCare healthCare , Integer id) {
	HealthCare existingHealthCare =repository.findById(id).orElse(healthCare);
	
	existingHealthCare.setAdmin(healthCare.getAdmin());
	existingHealthCare.setClient(healthCare.getClient());
	existingHealthCare.setPendingApproval(healthCare.getPendingApproval());
	existingHealthCare.setHistory(healthCare.getHistory());
	
	repository.save(healthCare);
	return existingHealthCare;
	
	
		
	};
	

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}
}

	
	

	