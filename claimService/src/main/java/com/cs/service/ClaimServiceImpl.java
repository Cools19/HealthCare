package com.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.model.Claim;
import com.cs.repository.IClaimRepository;
import com.cs.service.exceptionhandling.ResourceNotFoundException;



@Service
public class ClaimServiceImpl implements IClaimService {
	

	@Autowired
	IClaimRepository claimRepository;
	
	

	@Override
	public Integer saveClaimService(Claim claim) {
		
		Claim savedClaimService = claimRepository.save(claim);
		return savedClaimService.getId();
	}

	@Override
	public List<Claim> fetchAllClaimService() {
		return claimRepository.findAll();
	}

	@Override
	public Optional<Claim> fetchClaimService(Integer id) {
		return claimRepository.findById(id);
	}

	@Override
	public String deleteClaimService(Integer id) {
		claimRepository.deleteById(id);
		return "deleted";
	}

	@Override
	public Claim updateClaimService(Claim claimService, Integer id) {
		Claim existedClaim = claimRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("claim", "id", id));

		existedClaim.setClaimType(claimService.getClaimType());
		existedClaim.setClaimAmount(claimService.getClaimAmount());
		existedClaim.setClaimDate(claimService.getClaimDate());
		existedClaim.setRemark(claimService.getRemark());
		existedClaim.setStatus(claimService.getStatus());
		existedClaim.setMemberId(claimService.getMemberId());
		existedClaim.setPhysicianId(claimService.getPhysicianId());
		
		claimRepository.save(claimService);
		return existedClaim;

	}

	@Override
	public void deleteAll() {
		claimRepository.deleteAll();
	}

	@Override
	public Claim updateApproval( Integer id) {
		Claim existingMember = claimRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("claim", "id", id));

		
		existingMember.setStatus("Approved");
		
		claimRepository.save(existingMember);
		return existingMember;
	}
	
	
}
