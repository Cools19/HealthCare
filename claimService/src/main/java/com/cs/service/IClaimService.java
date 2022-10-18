package com.cs.service;

import java.util.List;
import java.util.Optional;

import com.cs.model.Claim;

public interface IClaimService {
	
	Integer saveClaimService(Claim claimService);
	public List<Claim> fetchAllClaimService();
	Optional<Claim> fetchClaimService(Integer id);
	public String deleteClaimService(Integer id);
	public Claim updateClaimService(Claim claimService, Integer id) ;
	public void deleteAll();
	Claim updateApproval( Integer id);

}
