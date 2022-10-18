package com.hc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.model.HealthCare;
import com.hc.service.IService;



@RestController
public class Controller {
	
	@Autowired
	IService  service;
	
	@GetMapping ("/healthCare")
	public String hello() {
		return"hello";
		
	}
	
	@PostMapping("/health")
	Integer createHealthCare(@RequestBody HealthCare healthCare) {
		Integer id = service.saveHealthCare(healthCare);
		System.out.println(id);
		return id;
		
		
	}
	
	@GetMapping("/allHealthCare")
	public List<HealthCare> gethealthCare(){
		return service.getAllHealthCare();
		
		
	}
	
	@DeleteMapping("/deleteHealthCare")
	public String deleteAllHealthCare() {
		service.deleteAll();
		return"Deleleted all healthCare";
		
	}
	
	@GetMapping("/getHealthCare/{id}")
	public Optional<HealthCare>getHealthCare(@PathVariable Integer id){
		Optional<HealthCare> healthCare = service.getHealthCare(id);
		return healthCare;
	}
	
	@DeleteMapping ("/deleteHealth/{id}")
	public ResponseEntity <HealthCare>deleteHealthCare(@PathVariable Integer id){
		
		System.out.println(id);
		ResponseEntity <HealthCare> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			service.deleteHealthCare(id);
			
		}
		

catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			
		}
		return responseEntity;
		
		 }
	
	@PutMapping("/updateHealthCare/{id}")
public ResponseEntity<HealthCare>updatehealthCare(@PathVariable("id") Integer id,@RequestBody HealthCare healthCare){
	return new ResponseEntity <HealthCare>(service.updateHealthCare( healthCare,id),HttpStatus.OK);
}
}
