package com.cs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String claimType;
	private String claimAmount;
	private String claimDate;
	private String remark;
	private String status;
	private String memberId;
	private String physicianId;
	
	

}
