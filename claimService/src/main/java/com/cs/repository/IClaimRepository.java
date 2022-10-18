package com.cs.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.model.Claim;

@Repository
public interface IClaimRepository  extends JpaRepository < Claim, Integer>{

}
