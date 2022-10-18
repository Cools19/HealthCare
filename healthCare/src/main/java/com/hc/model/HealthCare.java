package com.hc.model;
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
@AllArgsConstructor
@NoArgsConstructor

public class HealthCare {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String admin;
	public String client;
	public String pendingApproval;
	public String history;

	
}
