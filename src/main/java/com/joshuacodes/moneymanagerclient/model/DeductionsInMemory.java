package com.joshuacodes.moneymanagerclient.model;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeductionsInMemory {
	
	private Set<DeductionDTO> deductions;

	private DeductionsInMemory() {
		 deductions = new HashSet<>();
	}
	
	public void add(DeductionDTO deduction) {
		deductions.add(deduction);
	}
	
	public void remove(DeductionDTO deduction) {
		deductions.remove(deduction);
	}
	
	public Set<DeductionDTO> getDeductions() {
		//return defensive copy
		Set<DeductionDTO> copiedDeductions = new HashSet<>();
		copiedDeductions.addAll(deductions);
		return copiedDeductions;
	}

	public void removeAll() {
		deductions = new HashSet<>();
	}


}
