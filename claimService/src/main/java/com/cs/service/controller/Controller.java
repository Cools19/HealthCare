package com.cs.service.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cs.model.Claim;
import com.cs.service.IClaimService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("api/v1/claim")
public class Controller {
	
	
	@Autowired
	IClaimService claimService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	 
	 @PostMapping("/createclaim")
	 Integer createClaimService(@RequestBody Claim claim ) {
		 Integer id =claimService.saveClaimService(claim);
		 System.out.println(id);
		 return id;
	 }
	 
	 @GetMapping("/allClaims")
	 public List<Claim> fetchClaimService(){
		 return claimService.fetchAllClaimService();
	 }
	 
	 @DeleteMapping("/deleteClaims")
	 public String deleteAllClaims(){
		claimService.deleteAll();
		return "Deleted all claims";
	 }
	 
	 @DeleteMapping("/deleteClaims/{id}")
	 public String deleteClaimService (@PathVariable Integer id){
		 return claimService.deleteClaimService(id);
	 }
		 
	 @GetMapping("/getClaims/{id}")
	 public Optional<Claim> fetchClaimsService(@PathVariable Integer id){
		 Optional<Claim> claim = claimService.fetchClaimService(id);
		 return claim; 
	 }
	 
	 @PutMapping("/updateClaim/{id}")
	 public ResponseEntity<Claim> upadteclaimService(@PathVariable("id") Integer id, @RequestBody Claim claim){
		 return new ResponseEntity<Claim>(claimService.updateClaimService(claim,id),HttpStatus.OK);
		 
	 }
	 
	 @PatchMapping("/approval/{id}")
	 public ResponseEntity<Claim> upadteApproval(@PathVariable("id") Integer id){
		 System.out.println("-----------------------------ENTERED UPDATE PATCH");
		 return new ResponseEntity<Claim>(claimService.updateApproval(id),HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/fetchMembers")
	 public List fetchMembers(){
		 List members = this.restTemplate.getForObject("http://localhost:8060/api/v1/member/allMemberService", List.class);
			return members;
	 }
	 
	 @GetMapping("/fetchPhysicians")
	 public List fetchPhysicians(){
		 List members = this.restTemplate.getForObject("http://localhost:8060/api/v1/member/allPhysicians", List.class);
			return members;
	 }
	 
	 @GetMapping("/fetchAdmins")
	 public List fetchAdmins(){
		 List members = this.restTemplate.getForObject("http://localhost:8060/api/v1/member/allAdmins", List.class);
			return members;
	 }
	 
	 
	}
	


